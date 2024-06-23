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
import java.util.regex.Pattern;
import javax.print.attribute.standard.MediaSize;
import model.User;

/**
 *
 * @author ASUS
 */
public class VerifyEmailChangePass extends HttpServlet {

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
            out.println("<title>Servlet VerifyEmailChangePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyEmailChangePass at " + request.getContextPath() + "</h1>");
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
        String newpass = request.getParameter("newpass");
        String confirmpass = request.getParameter("confirmnewpass");
        int idUser = Integer.parseInt(request.getParameter("userIDChange"));
        JobseekerDAO jd = new JobseekerDAO();

        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

        User u = jd.findById(idUser);
        if (newpass.equals(confirmpass)) {
            if (!p.matcher(newpass).find()) {
                request.setAttribute("user", u);
                request.setAttribute("notice", "New password have [0-9],[a-z],[A-Z],[!-&]");
                request.getRequestDispatcher("updatepass.jsp").forward(request, response);
            } else {

                if (jd.changePass(idUser, newpass)) {
                    request.setAttribute("successfully", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            }

        } else {
            request.setAttribute("user", u);
            request.setAttribute("notice", "New password and Confirm password are not the same");
            request.getRequestDispatcher("updatepass.jsp").forward(request, response);
        }

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
        int role = Integer.parseInt(request.getParameter("role"));
        if (role == 2) {

            JobseekerDAO jd = new JobseekerDAO();
            int idUser = Integer.parseInt(request.getParameter("userID"));
            int token = Integer.parseInt(request.getParameter("token"));
            User u = jd.findById(idUser);
            String opt1 = request.getParameter("otp-input1");
            String opt2 = request.getParameter("otp-input2");
            String opt3 = request.getParameter("otp-input3");
            String opt4 = request.getParameter("otp-input4");
            String opt5 = request.getParameter("otp-input5");
            String opt6 = request.getParameter("otp-input6");
            //handleOTP string from input otpchsecker

            String otp = opt1 + opt2 + opt3 + opt4 + opt5 + opt6;

            int numOTP = Integer.parseInt(otp);
            if (token == numOTP) {
                request.setAttribute("user", u);
                request.getRequestDispatcher("updatepass.jsp").forward(request, response);
            } else {
                request.setAttribute("userID", idUser);
                request.setAttribute("token", token);

                request.setAttribute("notice", "Token invalid!");
                request.getRequestDispatcher("otpchangepass.jsp").forward(request, response);
            }

        } else if (role == 3) {

            JobseekerDAO jd = new JobseekerDAO();
            int idUser = Integer.parseInt(request.getParameter("userID"));
            int token = Integer.parseInt(request.getParameter("token"));
            User u = jd.findById(idUser);
            String opt1 = request.getParameter("otp-input1");
            String opt2 = request.getParameter("otp-input2");
            String opt3 = request.getParameter("otp-input3");
            String opt4 = request.getParameter("otp-input4");
            String opt5 = request.getParameter("otp-input5");
            String opt6 = request.getParameter("otp-input6");
            //handleOTP string from input otpchsecker

            String otp = opt1 + opt2 + opt3 + opt4 + opt5 + opt6;

            int numOTP = Integer.parseInt(otp);
            if (token == numOTP) {
                request.setAttribute("user", u);
                request.getRequestDispatcher("updatepassemployeer.jsp").forward(request, response);
            } else {
                request.setAttribute("userID", idUser);
                request.setAttribute("token", token);

                request.setAttribute("notice", "Token invalid!");
                request.getRequestDispatcher("otpchangepassemployeer.jsp").forward(request, response);
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
