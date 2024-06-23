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
public class VerifyEmailRegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet VerifyEmailRegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyEmailRegisterServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        int role = Integer.parseInt(request.getParameter("role"));
        if (role == 2) {
            if (action.equals("resend")) {

                String jobseekerFirstName = request.getParameter("firstname");
                String jobseekerLastName = request.getParameter("lastname");
                String jobseekerEmail = request.getParameter("email");
                String jobseekerPassword = request.getParameter("pass");
                SendEmail se = new SendEmail();

                Random random = new Random();
                int token = random.nextInt(1000000);

                se.sendMailVeri(jobseekerEmail, jobseekerLastName + " " + jobseekerFirstName, token);

                request.setAttribute("jobseekerFirstName", jobseekerFirstName);
                request.setAttribute("jobseekerLastName", jobseekerLastName);
                request.setAttribute("jobseekerEmail", jobseekerEmail);
                request.setAttribute("jobseekerPassword", jobseekerPassword);
                request.setAttribute("reqToken", token);
                request.getRequestDispatcher("otpchecker.jsp").forward(request, response);
            }
        } else if (role == 3) {
            if (action.equals("resend")) {

                String jobseekerFirstName = request.getParameter("firstname");
                String jobseekerLastName = request.getParameter("lastname");
                String jobseekerEmail = request.getParameter("email");
                String jobseekerPassword = request.getParameter("pass");
                SendEmail se = new SendEmail();

                Random random = new Random();
                int token = random.nextInt(1000000);

                se.sendMailVeri(jobseekerEmail, jobseekerLastName + " " + jobseekerFirstName, token);

                request.setAttribute("jobseekerFirstName", jobseekerFirstName);
                request.setAttribute("jobseekerLastName", jobseekerLastName);
                request.setAttribute("jobseekerEmail", jobseekerEmail);
                request.setAttribute("jobseekerPassword", jobseekerPassword);
                request.setAttribute("reqToken", token);
                request.getRequestDispatcher("otpcheckeremployeer.jsp").forward(request, response);
            }
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

        String action = request.getParameter("action");
        int role = Integer.parseInt(request.getParameter("role"));
        if (role == 2) {

            if (action.equals("verify")) {
                String jobseekerFirstName = request.getParameter("jobseekerFirstName");
                String jobseekerLastName = request.getParameter("jobseekerLastName");
                String jobseekerEmail = request.getParameter("jobseekerEmail");
                String jobseekerPassword = request.getParameter("jobseekerPassword");
                // data from user jobseeker regis

                int reqToken = Integer.parseInt(request.getParameter("reqToken"));
                //reqToken from Regis

                String opt1 = request.getParameter("otp-input1");
                String opt2 = request.getParameter("otp-input2");
                String opt3 = request.getParameter("otp-input3");
                String opt4 = request.getParameter("otp-input4");
                String opt5 = request.getParameter("otp-input5");
                String opt6 = request.getParameter("otp-input6");
                //handleOTP string from input otpchsecker

                String otp = opt1 + opt2 + opt3 + opt4 + opt5 + opt6;

                int numOTP = Integer.parseInt(otp);

                if (reqToken == numOTP) {
                    JobseekerDAO jd = new JobseekerDAO();
                    User u = new User(jobseekerFirstName, jobseekerLastName, jobseekerEmail, jobseekerPassword, 2);
                    if (jd.insert(u)) {
                        request.setAttribute("successfully", true);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("notice", "Email already exists on the system.");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("jobseekerFirstName", jobseekerFirstName);
                    request.setAttribute("jobseekerLastName", jobseekerLastName);
                    request.setAttribute("jobseekerEmail", jobseekerEmail);
                    request.setAttribute("jobseekerPassword", jobseekerPassword);
                    request.setAttribute("notice", "Invalid code");
                    request.setAttribute("reqToken", reqToken);
                    request.getRequestDispatcher("otpchecker.jsp").forward(request, response);

                }

            }

        } else if (role == 3) {

            if (action.equals("verify")) {
                String jobseekerFirstName = request.getParameter("jobseekerFirstName");
                String jobseekerLastName = request.getParameter("jobseekerLastName");
                String jobseekerEmail = request.getParameter("jobseekerEmail");
                String jobseekerPassword = request.getParameter("jobseekerPassword");
                // data from user jobseeker regis

                int reqToken = Integer.parseInt(request.getParameter("reqToken"));
                //reqToken from Regis

                String opt1 = request.getParameter("otp-input1");
                String opt2 = request.getParameter("otp-input2");
                String opt3 = request.getParameter("otp-input3");
                String opt4 = request.getParameter("otp-input4");
                String opt5 = request.getParameter("otp-input5");
                String opt6 = request.getParameter("otp-input6");
                //handleOTP string from input otpchsecker

                String otp = opt1 + opt2 + opt3 + opt4 + opt5 + opt6;

                int numOTP = Integer.parseInt(otp);

                if (reqToken == numOTP) {
                    JobseekerDAO jd = new JobseekerDAO();
                    User u = new User(jobseekerFirstName, jobseekerLastName, jobseekerEmail, jobseekerPassword, 3);
                    if (jd.insert(u)) {
                        request.setAttribute("successfully", true);
                        request.getRequestDispatcher("loginemployeer.jsp").forward(request, response);
                    } else {
                        request.setAttribute("notice", "Email already exists on the system.");
                        request.getRequestDispatcher("registeremployeer.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("jobseekerFirstName", jobseekerFirstName);
                    request.setAttribute("jobseekerLastName", jobseekerLastName);
                    request.setAttribute("jobseekerEmail", jobseekerEmail);
                    request.setAttribute("jobseekerPassword", jobseekerPassword);
                    request.setAttribute("notice", "Invalid code");
                    request.setAttribute("reqToken", reqToken);
                    request.getRequestDispatcher("otpcheckeremployeer.jsp").forward(request, response);

                }

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
