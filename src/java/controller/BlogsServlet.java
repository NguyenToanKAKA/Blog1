package controller;

import dao.BlogDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BlogDTO;
import services.BlogService;

@WebServlet(name = "BlogsServlet", urlPatterns = {"/blogs"})
public class BlogsServlet extends HttpServlet {

    private BlogService blogService = new BlogService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        String keyword = request.getParameter("search2");
        List<BlogDTO> blogs;
        int noOfBlogs;

        if (keyword != null && !keyword.isEmpty()) {
            blogs = blogService.searchBlogs(keyword);
            noOfBlogs = blogs.size();
        } else {
            blogs = blogService.getAllBlogs(page);
            noOfBlogs = blogService.getNoOfBlogs();
        }

        // Lấy danh sách ba bài viết có lượt like cao nhất
        List<BlogDTO> influencePosts = blogService.getTop3BlogsByLikes();

        int noOfPages = (int) Math.ceil(noOfBlogs * 1.0 / 4);

        // Set attribute để gửi danh sách và dữ liệu khác tới JSP
        request.setAttribute("influencePosts", influencePosts);
        request.setAttribute("blogs", blogs);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("blog.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
