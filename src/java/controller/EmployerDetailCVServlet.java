/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CVDAO;
import dao.JobseekerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CVProfile;
import model.User;

/**
 *
 * @author Admin
 */
public class EmployerDetailCVServlet extends HttpServlet {

    // Từ trang khác khi click vào 1 jobseeker apply thì truyền id của jobseeker đó sang servlet này ,để xem detail cv
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jobseekerId = 0;
        try{
             jobseekerId = Integer.parseInt(request.getParameter("UserId"));
        }catch(Exception e){
            response.sendRedirect("login.jsp");
        }
        
        JobseekerDAO jsDAO = new JobseekerDAO();
        CVDAO cvDao = new CVDAO();
        String roleRequired = "employer";
        
        // Lay ra email cua jobseeker by id
        User newUser = jsDAO.findById(jobseekerId);
        // Neu ton tai jobseeker vs id do
        if(newUser != null){
            // Get all cookies from the request
            Cookie[] cookies = request.getCookies();
            String cuser = null;

            // Check if cookies are not null
            if (cookies != null) {
                // Loop through the cookies to find the one named "cuser"
                for (Cookie cookie : cookies) {
                    if ("cuser".equals(cookie.getName())) {
                        cuser = cookie.getValue();
                        break; // Exit loop once the cookie is found
                    }
                }
            }

            // Nếu đã login 
            if (cuser != null) {
                String roleName = jsDAO.getRoleByEmail(cuser);
                //Nếu role là jobseeker ,gọi jsp cvProfile
                if(roleName.toLowerCase().equalsIgnoreCase(roleRequired)){
                    // Truyền cv vs thông tin user sang jsp
                    // Gọi hàm DAO để lấy CVProfile dựa trên email
                    String jobseekerEmail = newUser.getEmail();
                    CVProfile cvProfile = cvDao.findByEmail(jobseekerEmail);
                    User user = jsDAO.findByEmail(jobseekerEmail);

                    if (cvProfile != null && user != null) {
                        // Xử lý link url ,nếu không đủ 4 dấu | cho 4 loại link thì điền thêm để in ra jsp không lỗi
                        String linkUrl = cvProfile.getLinkUrl();
                         // Kiểm tra xem chuỗi có ít hơn 3 kí tự '|' không
                        int count = countOccurrences(linkUrl, '|');
                        if (count < 3) {
                            // Tính số lượng kí tự '|' cần thêm vào
                            int diff = 3 - count;

                            // Thêm kí tự '|' vào chuỗi để có đủ 4 kí tự '|'
                            for (int i = 0; i < diff; i++) {
                                linkUrl += "|";
                            }
                        }


                        // Truyền thông tin CVProfile, user qua request
                        request.setAttribute("cv", cvProfile);
                        request.setAttribute("user", user);
                        // Chuyển hướng đến trang JSP
                        request.getRequestDispatcher("CVProfileForView.jsp").forward(request, response);
                    } else {
                        response.getWriter().println("Không tìm thấy CVProfile cho email: " + cuser);
                    }
                }
                //Nếu role không phải jobseeker ,chuyển trang login
                else{
                    response.sendRedirect("login.jsp");
                }
            } 

            // Nếu chưa login chuyển sang trang login 
            else {
               response.sendRedirect("login.jsp");
            }
        }
        else {
            response.getWriter().println("Không tìm thấy jobseeker cho id: " + jobseekerId);
        }
    }
    
     // Hàm đếm số lần xuất hiện của một kí tự trong chuỗi
    public int countOccurrences(String inputString, char ch) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
