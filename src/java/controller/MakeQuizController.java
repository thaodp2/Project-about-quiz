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

import dao.QuestionDAO;
import dao.impl.QuestionDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains answer method that gets parameter user, question, answer,
 * trueAnswer from the HTTP request; calls <code>QuestionDAO</code>, to insert
 * question into question table and answer to answer table; Servlet will
 * directly respond to "errorPage.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class MakeQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request provides important information about answer client request
     * to answer servlet. It is
     * answer<code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * answer <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if answer servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Method is used to set value for body attribute then forward to the
     * layout.jsp
     *
     * @param request stores attributes: noPermiss to send to JSP. It is answer
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * answer <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if answer servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("body", "makeQuiz.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * Method is used to get parameter question, answer and trueAnswer from the
     * HTTP request; calls <code>QuestionDAO</code> and to insert question into
     * question table and answer to answer table; Servlet will directly respond
     * to "errorPage.jsp" when any error occurs
     *
     * @param request stores attributes: question, answer, trueAnswer, notice,
     * choice, body, error to send to JSP. It is answer
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * answer <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if answer servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String question = request.getParameter("question").trim();
            String[] listAnswerInput = request.getParameterValues("answer");
            String[] listCorrectAnswers = request.getParameterValues("trueAnswer");
            boolean checkEmty = true;
            boolean checkCountCorreAS = true;
            boolean checkMakeQuizSusscess = false;
            int count = 0;
            for (String list : listAnswerInput) {
                if (list.trim().equals("")) {
                    checkEmty = false;
                    break;
                }
            }
            if (question.trim().equals("")) {
                request.setAttribute("answer", listAnswerInput);
                request.setAttribute("notice", "Question canot Emty");
            } else if (checkEmty == false) {
                request.setAttribute("question", question);
                request.setAttribute("answer", listAnswerInput);
                request.setAttribute("notice", "Option can not emty!!");
            } else if (listCorrectAnswers == null) {
                request.setAttribute("question", question);
                request.setAttribute("answer", listAnswerInput);
                request.setAttribute("notice", "Please choose correct answer.");

            } else if (listCorrectAnswers.length == 4) {
                request.setAttribute("question", question);
                request.setAttribute("answer", listAnswerInput);
                request.setAttribute("notice", "You can only choose from 1 to 3 correct answers");

            } else {
                QuestionDAO questionDAO = new QuestionDAOImpl();
                List<Integer> listPositionOfTrueAnswer = new ArrayList<>();
                for (String string : listCorrectAnswers) {
                    listPositionOfTrueAnswer.add(Integer.parseInt(string));
                }
                questionDAO.addQuestionAndAnswer(question, listAnswerInput, listPositionOfTrueAnswer);
                checkMakeQuizSusscess = true;
                request.setAttribute("sucssessMakeQuiz", "Insert questtion success");
            }
            request.setAttribute("checkMakeQuiz", checkMakeQuizSusscess);
            request.setAttribute("body", "makeQuiz.jsp");
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
