package controller;

import dao.BlogDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Blog;
import model.User;

@WebServlet(name = "ManagerBlogController", urlPatterns = {"/managerblog"})
public class ManagerBlogController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        BlogDAO blogDAO = new BlogDAO();
        int currentPage = 1;
        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }
        int userId = account.getIdUser();
        int noOfBlogs = blogDAO.getNoOfBlogsByUserId(userId);
        int noOfPages = (int) Math.ceil(noOfBlogs * 1.0 / 3);

        List<Blog> blogs = blogDAO.getProductsBySellId(userId, currentPage);

        request.setAttribute("listP", blogs);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", currentPage);
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
        return "Short description";
    }
}
