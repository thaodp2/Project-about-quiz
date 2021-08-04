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
import entity.Question;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method get parameter page from the HTTP request; calls
 * <code>QuestionDAO</code> to count question, get list question with paging. 
 * Servlet will directly respond to "errorPage.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class ManageQuizController extends HttpServlet {

    /**
     * This method gets parameter page from the HTTP request; calls 
     * <code>QuestionDAO</code> to get list question with paging then forward 
     * to "layout.jsp". Servlet will directly respond to "errorPage.jsp" when any
     * error occurs
     *
     * @param request stores attributes: page, listResult, totalPage,
     * currentPage,numberOfQuestion, body, error to send to JSP. It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 3;
            String pageRequest = request.getParameter("page");
            int page = 1;
            if (pageRequest != null) {
                try {
                    page = Integer.parseInt(pageRequest);
                } catch (Exception e) {
                    request.setAttribute("errorManage", true);
                    request.setAttribute("body", "errorPage.jsp");
                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("layout.jsp").forward(request, response);
                }
            }
            QuestionDAO questionDAO = new QuestionDAOImpl();
            int totalQuestion = questionDAO.getTotalQuestion();
            int totalPage = (int) Math.ceil((double) totalQuestion / pageSize);

            if (page <= totalPage) {
                List<Question> listResult = questionDAO.getQuestion(page, pageSize);
                request.setAttribute("listResult", listResult);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", page);
            } else {
                request.setAttribute("errorManage", true);
            }
            request.setAttribute("numberOfQuestion", totalQuestion);
            request.setAttribute("body", "manageQuiz.jsp");
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("body", "errorPage.jsp");
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
