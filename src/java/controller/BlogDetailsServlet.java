/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BlogDTO;
import model.BlogDetailDTO;
import model.UserDTO;
import services.BlogService;

/**
 *
 * @author This PC
 */
@WebServlet(name = "BlogDetailsServlet", urlPatterns = {"/blogDetails"})
public class BlogDetailsServlet extends HttpServlet {

    private BlogService blogService = new BlogService();
    private UserDAO userDAO = new UserDAO();
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int blogId = Integer.parseInt(request.getParameter("bid"));

        // Lấy chi tiết blog
        BlogDetailDTO blog = blogService.getBlogDetails(blogId);

        // Lấy thông tin người viết blog
        UserDTO author = userDAO.getUserById(blog.getUserId());

        // Lấy danh sách bài viết ảnh hưởng
        List<BlogDTO> influencePosts = blogService.getTop3BlogsByLikes();

        // Đặt các thuộc tính vào request để chuyển đến JSP
        request.setAttribute("blog", blog);
        request.setAttribute("author", author);
        request.setAttribute("influencePosts", influencePosts);

        // Điều hướng đến trang blog-details.jsp
        request.getRequestDispatcher("blog-details.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
