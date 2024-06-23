/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.JobseekerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ASUS
 */
public class LoginJobseeker extends HttpServlet {

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
            out.println("<title>Servlet LoginJobseeker</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginJobseeker at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
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
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String rem = request.getParameter("rem");
            HttpSession session = request.getSession();

            Cookie cuser = new Cookie("cuser", email);
            Cookie cpass = new Cookie("cpass", pass);
            Cookie crem = new Cookie("crem", rem);
            if (rem != null) {
                cuser.setMaxAge(60 * 60 * 24 * 7);
                cpass.setMaxAge(60 * 60 * 24 * 7);
                crem.setMaxAge(60 * 60 * 24 * 7);

            } else {
                cuser.setMaxAge(0);
                cpass.setMaxAge(0);
                crem.setMaxAge(0);
            }
            response.addCookie(cuser);
            response.addCookie(cpass);
            response.addCookie(crem);

            JobseekerDAO jd = new JobseekerDAO();
            try {
                if (jd.loginAcount(email, pass).getRoleId() == 2) {
                    if (jd.loginAcount(email, pass).getStatus().equalsIgnoreCase("Lock")) {
                        request.setAttribute("notice", "Your account has been blocked! Please come back later. ");
                        request.getRequestDispatcher("login.jsp").forward(request, response);

                    } else {
                        session.setAttribute("account", jd.loginAcount(email, pass));
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

        } else if (role == 3) {

            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String rem = request.getParameter("rem");
            HttpSession session = request.getSession();

            Cookie cusere = new Cookie("cuser", email);
            Cookie cpasse = new Cookie("cpass", pass);
            Cookie creme = new Cookie("crem", rem);
            if (rem != null) {
                cusere.setMaxAge(60 * 60 * 24 * 7);
                cpasse.setMaxAge(60 * 60 * 24 * 7);
                creme.setMaxAge(60 * 60 * 24 * 7);

            } else {
                cusere.setMaxAge(0);
                cpasse.setMaxAge(0);
                creme.setMaxAge(0);
            }
            response.addCookie(cusere);
            response.addCookie(cpasse);
            response.addCookie(creme);

            JobseekerDAO jd = new JobseekerDAO();

            try {

                if (jd.loginAcount(email, pass).getRoleId() == 3) {
                    if (jd.loginAcount(email, pass).getStatus().equalsIgnoreCase("Lock")) {
                        request.setAttribute("notice", "Your account has been blocked! Please come back later. ");
                        request.getRequestDispatcher("loginemployeer.jsp").forward(request, response);

                    } else {
                        session.setAttribute("account", jd.loginAcount(email, pass));
                        response.sendRedirect("employerhomeservlet");
                    }

                } else {
                    request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                    request.getRequestDispatcher("loginemployeer.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                request.getRequestDispatcher("loginemployeer.jsp").forward(request, response);
            }
        } else {

            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            try {
                JobseekerDAO jd = new JobseekerDAO();

                if (jd.loginAcount(email, pass).getRoleId() == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("account", jd.loginAcount(email, pass));
                    request.getRequestDispatcher("adminDashBoard").forward(request, response);

                } else {
                    request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("notice", "Email or password is invalid. Please check again!!");
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }

        }
    }
    
    //h

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
