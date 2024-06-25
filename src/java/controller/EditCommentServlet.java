package controller;

import dao.CommentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class EditCommentServlet
 */
@WebServlet("/editComment")
public class EditCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CommentDAO commentDao = new CommentDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        String content = request.getParameter("content");

        boolean success = commentDao.updateComment(commentId, content);

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("success", success);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString());
    }
}
