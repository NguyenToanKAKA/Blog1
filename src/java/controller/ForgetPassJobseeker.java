/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import EmailAutoman.SendEmail;
import dao.JobseekerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import model.User;

/**
 *
 * @author ASUS
 */
public class ForgetPassJobseeker extends HttpServlet {

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
            out.println("<title>Servlet ForgetPassJobseeker</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgetPassJobseeker at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);

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
        String action = request.getParameter("action");
        int role = Integer.parseInt(request.getParameter("role"));
        if (role == 2) {
            String email = request.getParameter("email");

            JobseekerDAO jd = new JobseekerDAO();
            try {
                if (jd.fogortPass(email).getRoleId() == 2) {
                    User u = jd.fogortPass(email);
                    SendEmail se = new SendEmail();
                    Random random = new Random();
                    int token = random.nextInt(1000000);
                    se.sendMailChangePass(u.getEmail(), u.getLastName() + " " + u.getFirstName(), token);
                    request.setAttribute("userID", u.getIdUser());
                    request.setAttribute("token", token);
                    request.getRequestDispatcher("otpchangepass.jsp").forward(request, response);

                } else {
                    request.setAttribute("notice", "Email does not exist, please check again!");
                    request.getRequestDispatcher("forgetpass.jsp").forward(request, response);

                }

            } catch (Exception e) {
                request.setAttribute("notice", "Email does not exist, please check again!");
                request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
            }

        } else if (role == 3) {
            String email = request.getParameter("email");
            JobseekerDAO jd = new JobseekerDAO();

            try {
                if (jd.fogortPass(email).getRoleId() == 3) {
                    User u = jd.fogortPass(email);
                    SendEmail se = new SendEmail();
                    Random random = new Random();
                    int token = random.nextInt(1000000);
                    se.sendMailChangePass(u.getEmail(), u.getLastName() + " " + u.getFirstName(), token);
                    request.setAttribute("userID", u.getIdUser());
                    request.setAttribute("token", token);
                    request.getRequestDispatcher("otpchangepassemployeer.jsp").forward(request, response);

                } else {
                    request.setAttribute("notice", "Email does not exist, please check again!");
                    request.getRequestDispatcher("forgetpassemployeer.jsp").forward(request, response);

                }

            } catch (Exception e) {
                request.setAttribute("notice", "Email does not exist, please check again!");
                request.getRequestDispatcher("forgetpassemployeer.jsp").forward(request, response);

            }

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
