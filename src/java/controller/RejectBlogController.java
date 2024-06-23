package controller;

import dao.BlogDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Blog;
import model.User;

@WebServlet(name = "RejectBlogController", urlPatterns = {"/rejectblog"})
public class RejectBlogController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        
        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        int userId = account.getIdUser();
        
        BlogDAO blogDAO = new BlogDAO();
        List<Blog> blogs = blogDAO.getRejectBlogsByUserId(userId);

        request.setAttribute("listP", blogs);
        request.getRequestDispatcher("ManageBlog.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Accept Blog Controller";
    }
}
