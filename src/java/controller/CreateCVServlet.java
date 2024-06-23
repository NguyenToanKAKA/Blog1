/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CVDAO;
import dao.JobseekerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CVProfile;
import model.User;

/**
 *
 * @author Admin /createCV
 */
public class CreateCVServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("createCV.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user != null && user.getRoleId() == 2) {
            String linkYoutube = request.getParameter("linkYoutube");
            String linkPdf = request.getParameter("linkPdf");
            String linkAvt = request.getParameter("linkAvt");
            String education = request.getParameter("education");
            String skills = request.getParameter("skills");
            String experience = request.getParameter("experience");
            String certification = request.getParameter("certification");
            String description = request.getParameter("description");
            String linkTwitter = request.getParameter("linkTwitter");
            String linkFacebook = request.getParameter("linkFacebook");
            String linkLinkedin = request.getParameter("linkLinkedin");
            String linkUrl = linkYoutube + "|" + linkFacebook + "|" + linkTwitter + "|" + linkLinkedin;

            CVDAO cvDao = new CVDAO();

            CVProfile cvProfile = cvDao.findByEmail(user.getEmail());

            if (cvProfile == null) {
                CVProfile newCv = new CVProfile(user.getIdUser(), skills, experience, description, education, certification, linkUrl, linkAvt, linkPdf);
                cvDao.insert(newCv);
                response.sendRedirect("CVSeeker");
            } else {
                response.sendRedirect("CVSeeker");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }

}
