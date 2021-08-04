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

/**
 * This class contains a method that get parameter username, password,
 * email, user-type from the HTTP request; calls <code>UserDAO</code> to get
 * user exist, insert <code>User</code> to User table. Servlet will directly 
 * respond to "errorPage.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Method used to set value for body attribute then send direct to
     * layout.jsp
     *
     * @param request stores attributes: body to send to JSP. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("body", "register.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * This method that get parameter username, password, email, user-type
     * from the HTTP request; calls <code>UserDAO</code> to get all user was 
     * existed; redirect to "register.jsp" if user already existed, otherwise 
     * redirect to layout.jsp and insert <code>User</code> to User table. Servlet
     * will directly respond to "errorPage.jsp" when any error occurs
     *
     * @param request stores attributes: username, password, user-type,
     * email, error, isTeacher, isStudent, status, component to send to
     * "register.jsp" if register fail, otherwise store session user. It is a 
     * <code> javax.servlet.http.HttpServletRequest </code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String userType = request.getParameter("user-type").trim();
            String email = request.getParameter("email").trim();
            boolean isTeacher = false;
            //Check if the user has selected the teacher or not
            if (userType.equals("Teacher")) {
                isTeacher = true;
            }
            // Regex for username
            if (!username.matches("[A-Za-z0-9]*$") || username.length() < 3) {
                request.setAttribute("status", "Length of username must greater than 2"
                        + " and not contain space, special characters");
                request.setAttribute("body", "register.jsp");
                if (isTeacher) {
                    request.setAttribute("isTeacher", true);
                } else {
                    request.setAttribute("isStudent", true);
                }
                request.setAttribute("userName", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("layout.jsp").forward(request, response);
                // Regex for password
            } else if (!password.matches("[a-z0-9]*$") || password.length() < 5) {
                request.setAttribute("status", "Length of password must greater than 4"
                        + " and not contain space, special characters and uppercase letter");
                request.setAttribute("body", "register.jsp");
                if (isTeacher) {
                    request.setAttribute("isTeacher", true);
                } else {
                    request.setAttribute("isStudent", true);
                }
                request.setAttribute("userName", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("layout.jsp").forward(request, response);
            } // Regex for email
            else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                request.setAttribute("status", "Wrong email format!");
                request.setAttribute("body", "register.jsp");
                if (isTeacher) {
                    request.setAttribute("isTeacher", true);
                } else {
                    request.setAttribute("isStudent", true);
                }
                request.setAttribute("userName", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("layout.jsp").forward(request, response);
            } else {
                UserDAO userDAO = new UserDAOImpl();
                //Check if the username already exists or not
                if (userDAO.checkExitUser(username)) {
                    request.setAttribute("userName", username);
                    request.setAttribute("email", email);
                    if (isTeacher) {
                        request.setAttribute("isTeacher", true);
                    } else {
                        request.setAttribute("isStudent", true);
                    }
                    request.setAttribute("status", "Username already existed. Try again!");
                } else {
                    User user = new User(username, password, isTeacher, email);
                    userDAO.registerUser(user);
                    request.setAttribute("status", "Register successfully");
                }
            }

            request.setAttribute("body", "register.jsp");
            request.getRequestDispatcher("layout.jsp").forward(request, response);

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
