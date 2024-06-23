/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.JobseekerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Pattern;
import model.User;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class UpdateProfileJobseeker extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfileJobseeker</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfileJobseeker at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("pass");
        String confirmpasss = request.getParameter("confirmpass");
        String cityName = request.getParameter("cityname");
        String phoneNumber = request.getParameter("phone");
        String dobDate = request.getParameter("date");
        Date dob = Date.valueOf(dobDate);

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        JobseekerDAO jd = new JobseekerDAO();

        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (password.length() == 0 && confirmpasss.length() == 0) {

            User uu = new User(u.getIdUser(), firstName, lastName, u.getEmail(), u.getPassword(), u.getRoleId(), u.getMessage(), u.getStatus(), cityName, phoneNumber, dob);
            jd.update(uu);
            session.setAttribute("account", uu);
            request.setAttribute("successfully", true);
            request.getRequestDispatcher("profilejb.jsp").forward(request, response);

        } else if (password.length() != 0 && confirmpasss.length() != 0) {
            if (!p.matcher(password).find() || !p.matcher(confirmpasss).find()) {
                request.setAttribute("notice", "New password have [0-9],[a-z],[A-Z],[!-&]");
                request.getRequestDispatcher("profilejb.jsp").forward(request, response);
            } else if (!confirmpasss.equals(u.getPassword())) {
                request.setAttribute("notice", "Your old password incorrect!!!");
                request.getRequestDispatcher("profilejb.jsp").forward(request, response);

            } else {

                 User uu = new User(u.getIdUser(),firstName, lastName, u.getEmail(), password, u.getRoleId(), u.getMessage(), u.getStatus(), cityName, phoneNumber, dob);
                jd.update(uu);
                session.setAttribute("account", uu);
                request.setAttribute("successfully", true);
                request.getRequestDispatcher("profilejb.jsp").forward(request, response);
            }
        }else if (password.length() != 0 && confirmpasss.length() == 0) {
            if (!p.matcher(password).find()) {
                request.setAttribute("notice", "New password have [0-9],[a-z],[A-Z],[!-&]");
                request.getRequestDispatcher("profilejb.jsp").forward(request, response);
            } else {
                User uu = new User(u.getIdUser(), u.getFirstName(), u.getLastName(), u.getEmail(), password, 2, u.getMessage(), u.getStatus());
                jd.update(uu);
                session.setAttribute("account", uu);
                request.setAttribute("successfully", true);
                request.getRequestDispatcher("profilejb.jsp").forward(request, response);

            }

        } 

//        else if ((password.length() != 0 && confirmpasss.length() == 0) || password.length() == 0 && confirmpasss.length() != 0) {
//
//            request.setAttribute("notice", "Please fill in all information!!!");
//            request.getRequestDispatcher("profilejb.jsp").forward(request, response);
//
//        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
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
