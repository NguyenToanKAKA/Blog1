package controller;

import dao.LikeDAO;
import com.google.gson.Gson;
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
@WebServlet(name = "CheckLikeStatusServlet", urlPatterns = {"/checkLikeStatus"})
public class CheckLikeStatusServlet extends HttpServlet {

    private LikeDAO likeDao = new LikeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int uid = Integer.parseInt(request.getParameter("uid"));
        int bid = Integer.parseInt(request.getParameter("bid"));

        Like like = likeDao.getLikeByBlogIdAndUserId(bid, uid);
        boolean hasLiked = (like != null);

        // Prepare the JSON response
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(hasLiked);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}