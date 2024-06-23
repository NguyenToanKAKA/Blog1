/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LikeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Like;

/**
 *
 * @author This PC
 */
@WebServlet(name = "LikeBlogServlet", urlPatterns = {"/likeBlogs"})
public class LikeBlogServlet extends HttpServlet {

    private LikeDAO likeDao = new LikeDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int uid = Integer.parseInt(request.getParameter("uid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        
        this.likeDao.insert(new Like(uid, bid));
        
        response.sendRedirect("blogDetails?bid="+bid);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
