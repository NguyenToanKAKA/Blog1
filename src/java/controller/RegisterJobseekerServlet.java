/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import EmailAutoman.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.User;

/**
 *
 * @author ASUS
 */
public class RegisterJobseekerServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterJobseekerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterJobseekerServlet at " + request.getContextPath() + "</h1>");
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

        int role = Integer.parseInt(request.getParameter("role"));
        if (role == 2) {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
            Pattern pText = Pattern.compile("^[a-zA-Z]+$");

            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

            if (!pText.matcher(firstName).find()) {
                request.setAttribute("notice", "First name cann't containt [1-9] or[!-@]");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (!pText.matcher(lastName).find()) {
                request.setAttribute("notice", "Last name cann't containt [1-9] or[!-@]");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

            if (!p.matcher(password).find()) {
                request.setAttribute("notice", "Password have [0-9],[a-z],[A-Z],[!-&]");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
                request.setAttribute("notice", "Please complete all information.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            SendEmail se = new SendEmail();
            Random random = new Random();
            int token = random.nextInt(1000000);
            se.sendMailVeri(email, lastName + " " + firstName, token);

            request.setAttribute("jobseekerFirstName", firstName);
            request.setAttribute("jobseekerLastName", lastName);
            request.setAttribute("jobseekerEmail", email);
            request.setAttribute("jobseekerPassword", password);
            request.setAttribute("reqToken", token);
            //

            request.getRequestDispatcher("otpchecker.jsp").forward(request, response);

        } else if (role == 3) {

            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
            Pattern pText = Pattern.compile("^[a-zA-Z]+$");

            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

            if (!pText.matcher(firstName).find()) {
                request.setAttribute("notice", "First name cann't containt [1-9] or[!-@]");
                request.getRequestDispatcher("registeremployeer.jsp").forward(request, response);
            }
            if (!pText.matcher(lastName).find()) {
                request.setAttribute("notice", "Last name cann't containt [1-9] or[!-@]");
                request.getRequestDispatcher("registeremployeer.jsp").forward(request, response);
            }

            if (!p.matcher(password).find()) {
                request.setAttribute("notice", "Password have [0-9],[a-z],[A-Z],[!-&]");
                request.getRequestDispatcher("registeremployeer.jsp").forward(request, response);
            }
            if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
                request.setAttribute("notice", "Please complete all information.");
                request.getRequestDispatcher("registeremployeer.jsp").forward(request, response);
            }
            SendEmail se = new SendEmail();
            Random random = new Random();
            int token = random.nextInt(1000000);
            se.sendMailVeri(email, lastName + " " + firstName, token);

            request.setAttribute("jobseekerFirstName", firstName);
            request.setAttribute("jobseekerLastName", lastName);
            request.setAttribute("jobseekerEmail", email);
            request.setAttribute("jobseekerPassword", password);
            request.setAttribute("reqToken", token);
            //
            request.getRequestDispatcher("otpcheckeremployeer.jsp").forward(request, response);
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
