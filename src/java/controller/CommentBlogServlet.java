/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import model.Comment;

/**
 *
 * @author This PC
 */
@WebServlet(name = "CommentBlogServlet", urlPatterns = {"/commentBlog"})
public class CommentBlogServlet extends HttpServlet {

    private CommentDAO cmtDao = new CommentDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int uid = Integer.parseInt(request.getParameter("uid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        String content = request.getParameter("content");
        
        this.cmtDao.insert(new Comment(uid, bid, content,new Date().toString()));
        
        response.sendRedirect("blogDetails?bid="+bid);
        
    }
}
