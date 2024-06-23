package controller;

import dao.CommentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;

@WebServlet(name = "ReportCommentServlet", urlPatterns = {"/reportComment"})
public class ReportCommentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            int commentId = Integer.parseInt(request.getParameter("commentId"));
            User user = (User) request.getSession().getAttribute("account");

            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }


            CommentDAO commentDAO = new CommentDAO();
            boolean reported = commentDAO.updateStatus(commentId, "Report");

            if (reported) {
                response.sendRedirect(request.getContextPath() + "/blogDetails?bid=" + request.getParameter("blogId"));
            } else {
                request.setAttribute("reportError", "Failed to report comment.");
                response.sendRedirect(request.getContextPath() + "/blog-details.jsp");
            }
        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
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
