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

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class contains a method that get parameter username, password from the
 * HTTP request; calls <code>UserDAO</code> to get <code>User</code> by 
 * username and password. Servlet will directly respond to "errorPage.jsp" when
 * any error occurs
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request provides important information about a client request to a servlet. 
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. 
     * It is a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Method is used to get attribute user from the HTTP request then forward 
     * to the login.jsp if <code>User</code> null, forward to the userInfo.jsp 
     * if <code>User</code> != null. Servlet will directly respond to 
     * "errorPage.jsp" when any error occurs
     *
     * @param request stores attributes: body to send to JSP.
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("body", "login.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * Method is used to get parameter username and password from the HTTP request;
     * calls <code>UserDAO</code> to get <code>User</code> by username and 
     * password then forward to the login.jsp if <code>User</code> null, forward
     * to the layout.jsp if <code>User</code> != null. Servlet will directly 
     * respond to "errorPage.jsp" when any error occurs
     *
     * @param request stores attributes: userName, password, user, userName, 
     * error to send to JSP.
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        try {
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.getUserLoggedIn(userName, password);
            //Check if the user exists or not
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("body", "userInfo.jsp");
                request.getRequestDispatcher("layout.jsp").forward(request, response);
            } else {
                request.setAttribute("userName", userName);
                request.setAttribute("status", "Wrong username or password");
                request.setAttribute("body", "login.jsp");
                request.getRequestDispatcher("layout.jsp").forward(request, response);
            }           
        } catch (Exception e) {
            request.setAttribute("body", "errorPage.jsp");
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        }

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
