package controller;

import services.BlogService;
import model.BlogDTO;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    private BlogService blogService = new BlogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        List<BlogDTO> blogs;
        List<BlogDTO> influencePosts = blogService.getTop3BlogsByLikes();
        if (keyword != null && !keyword.trim().isEmpty()) {
            blogs = blogService.searchBlogs(keyword);
        } else {
            blogs = blogService.getAllBlogs(1); 
            
        }

        request.setAttribute("blogs", blogs);
        request.setAttribute("keyword", keyword);
        request.setAttribute("influencePosts", influencePosts);
        request.getRequestDispatcher("search_blog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Chuyển yêu cầu POST sang GET để xử lý tìm kiếm
    }
}
