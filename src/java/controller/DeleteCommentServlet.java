package controller;

import dao.CommentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteCommentServlet", urlPatterns = {"/deleteComment"})
public class DeleteCommentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // Lấy commentId từ request parameter
            int commentId = Integer.parseInt(request.getParameter("commentId"));

            // Gọi phương thức xóa comment từ CommentDAO
            CommentDAO commentDAO = new CommentDAO();
            boolean deleted = commentDAO.deleteComment(commentId);

            if (deleted) {
                // Điều hướng người dùng quay lại trang blog-details.jsp sau khi xóa
                response.sendRedirect(request.getContextPath() + "/blogDetails?bid=" + request.getParameter("blogId"));
            } else {
                // Nếu không xóa được, có thể thông báo lỗi và redirect về trang gốc hoặc trang comment
                request.setAttribute("deleteError", "Failed to delete comment.");
                response.sendRedirect(request.getContextPath() + "/blog-details.jsp");
            }
        } catch (NumberFormatException | IOException ex) {
            // Xử lý ngoại lệ nếu có
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
