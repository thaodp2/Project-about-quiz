/**
 * Copyright(C) 2021, DINH PHUONG THAO
 * J3.L.P0001
 * Online Quiz
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-21      1.0                 THAODP           First Implement
 * 2021-07-21      2.0                 THAODP           Second Implement
 */
package controller;

import dao.AnswerDAO;
import dao.QuestionDAO;
import dao.ResultDAO;
import dao.impl.AnswerDAOImpl;
import dao.impl.QuestionDAOImpl;
import dao.impl.ResultDAOImpl;
import entity.Question;
import entity.Result;
import entity.User;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that calls <code>QuestionDAO</code> and 
 * <code>AnswerDAO</code> to get total question; get parameter NumberQuestion
 * from the HTTP request; get number of questions the user wants to do and set 
 * time to do all question. Servlet will directly respond to "errorPage.jsp" 
 * when any error occurs
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class TakeQuizController extends HttpServlet {

    private Calendar submitTime = null;
    private Calendar startTime = null;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method that calls <code>QuestionDAO</code> to get total of 
     * question; get number of question that user inputed; get time to do all 
     * question then redirect to layout.jsp if don't have any error. Servlet will 
     * directly respond to "Error.jsp" when any error occurs
     *
     * @param request stores attributes: noPermiss, body, submitTakeQuiz,
     * quesList, questionId, realtime, time error to send to "layout.jsp". It is
     * a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if answer servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("noPermiss", "");
        request.setAttribute("body", "takeQuiz.jsp");
        if (request.getParameter("submitTakeQuiz") != null) {
            try {
                String NumberQuestion = request.getParameter("NumberQuestion").trim();
                int totalQuest = 0;
                QuestionDAO questionDAO = new QuestionDAOImpl();
                totalQuest = questionDAO.getTotalQuestion();
                //validate number question
                if (NumberQuestion.matches("[1-9]+")) {
                    AnswerDAO answerDAO = new AnswerDAOImpl();
                    int numberOfQuestion = Integer.parseInt(NumberQuestion);
                    if (numberOfQuestion > totalQuest) {
                        request.setAttribute("errorTakeQuiz", "You must enter a number < 0 and >" + totalQuest + " number");
                        request.setAttribute("body", "takeQuiz.jsp");
                    } else {
                        submitTime = Calendar.getInstance();
                        startTime = Calendar.getInstance();
                        int examTime = 30 * numberOfQuestion;
                        submitTime.add(submitTime.SECOND, examTime + numberOfQuestion);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time = simpleDateFormat.format(submitTime.getTime());
                        List<Question> listQuestion = new ArrayList<>();
                        listQuestion = questionDAO.getRandomQuestion(numberOfQuestion);
                        //set list answer for each question
                        for (Question question : listQuestion) {
                            question.setAnswerList(answerDAO.getAnswerByQuestionId(question.getId()));
                        }
                        request.setAttribute("quesList", listQuestion);
                        request.setAttribute("realtime", examTime);
                        request.setAttribute("time", time);
                        request.setAttribute("body", "doQuiz.jsp");
                    }
                } else {
                    request.setAttribute("errorTakeQuiz", "You must enter a number < 0 and >" + totalQuest + " number");
                    request.setAttribute("body", "takeQuiz.jsp");
                }
            } catch (Exception e) {
                request.setAttribute("body", "errorPage.jsp");
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("layout.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * This method that calls <code>AnswerDAO</code> to get all answer of 
     * question; get score and result of test then redirect to layout.jsp if 
     * don't have any error. Servlet will directly respond to "errorPage.jsp" 
     * when any error occurs
     *
     * @param request stores attributes: noPermiss, body, score, percent,
     * timeover, body to send to "layout.jsp". It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if answer servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            User user = (User) request.getSession().getAttribute("user");
            boolean isPassed = false;
            double score = 0;
            Calendar calendar = Calendar.getInstance();
            //check cheating. when user have submit time is after the time allowed
            if (calendar.after(submitTime)) {
                request.setAttribute("timeover", "Submission time is after the time allowed.");
                request.setAttribute("body", "showScore.jsp");
            } else {

                //list of question id
                String[] questionId = request.getParameterValues("quenstionId");
                //number of question
                double totalQuestion = questionId.length;

                AnswerDAO answerDAO = new AnswerDAOImpl();
                //number of question choose wrong answer
                int totalWrongAnswers = 0;
                //count the number of questions that choose the wrong answer
                for (String question : questionId) {
                    String[] choiceAnswer = request.getParameterValues("answer-for-" + question);
                    //No answer selected
                    if (choiceAnswer == null) {
                        totalWrongAnswers++;
                        //The number of selected answers is more than the correct number of correct answers
                    } else if (choiceAnswer.length != answerDAO.getTotalTrueAnswerByQuestionId(Integer.parseInt(question))) {
                        totalWrongAnswers++;
                        //selected wrong answer
                    } else {
                        for (String answer : choiceAnswer) {
                            if (!answerDAO.getAnswerById(Integer.parseInt(answer)).isIsTrue()) {
                                totalWrongAnswers++;
                                break;
                            }
                        }
                    }
                }
                score = ((totalQuestion - totalWrongAnswers) / totalQuestion) * 10;
                NumberFormat formatter = new DecimalFormat("##.#");
                NumberFormat formatPercent = new DecimalFormat("#");
                score = Double.valueOf(formatter.format(score));
                if (score >= 5) {
                    isPassed = true;
                }
                request.setAttribute("score", score);
                request.setAttribute("percent", formatPercent.format(score * 10));
                request.setAttribute("body", "showScore.jsp");
            }
            //Insert test result into db
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String start = simpleDateFormat.format(startTime.getTime());
            String end = simpleDateFormat.format(new Date());
            ResultDAO resultDAO = new ResultDAOImpl();
            resultDAO.addResult(new Result(user.getId(), score,
                    simpleDateFormat.parse(start), simpleDateFormat.parse(end), isPassed));
            //End Insert
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("body", "errorPage.jsp");
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        }
    }

    /**
     * Returns answer short description of the servlet.
     *
     * @return answer String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
