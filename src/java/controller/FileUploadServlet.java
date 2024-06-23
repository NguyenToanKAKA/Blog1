/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
// Import thư viện Gson
import com.google.gson.JsonObject;

//@WebServlet("/upload")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//                 maxFileSize = 1024 * 1024 * 10,      // 10MB
//                 maxRequestSize = 1024 * 1024 * 50)   // 50MB

public class FileUploadServlet extends HttpServlet {
    
    private static final String UPLOAD_DIR = "assets/pdf/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        //String uploadFilePath = "D:\\CodeThue\\Ki_8\\SWP_Profile\\Project\\EasyJob1\\web\\assets\\images\\";
        
        // Create the directory if it does not exist
        File fileUploadDir = new File(uploadFilePath);
        if (!fileUploadDir.exists()) {
            fileUploadDir.mkdirs();
        }

        String fileName = "";
        for (Part part : request.getParts()) {
             fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = uploadFilePath + File.separator + fileName;
                part.write(filePath);
                //response.getWriter().println("File " + fileName + " uploaded successfully to " + filePath);
            }
        }
        
           // Create JSON object manually
            System.out.println(fileName);

            // Tạo một đối tượng JSON bằng Gson
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("fileName", fileName);
            // Set content type và gửi JSON response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonResponse.toString());
            out.flush();
    }
    
//     private static final String UPLOAD_DIR = "assets/images/";
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        String applicationPath = request.getServletContext().getRealPath("");
//        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
//
//        //String uploadFilePath = "D:\\CodeThue\\Ki_8\\SWP_Profile\\Project\\EasyJob1\\web\\assets\\images\\";
//        
//        // Create the directory if it does not exist
//        File fileUploadDir = new File(uploadFilePath);
//        if (!fileUploadDir.exists()) {
//            fileUploadDir.mkdirs();
//        }
//
//        String fileName = "";
//        for (Part part : request.getParts()) {
//             fileName = extractFileName(part);
//            if (fileName != null && !fileName.isEmpty()) {
//                String filePath = uploadFilePath + File.separator + fileName;
//                part.write(filePath);
//                //response.getWriter().println("File " + fileName + " uploaded successfully to " + filePath);
//            }
//        }
//        
//           // Create JSON object manually
//            System.out.println(fileName);
//
//            // Tạo một đối tượng JSON bằng Gson
//            JsonObject jsonResponse = new JsonObject();
//            jsonResponse.addProperty("fileName", fileName);
//            // Set content type và gửi JSON response
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out = response.getWriter();
//            out.print(jsonResponse.toString());
//            out.flush();
//    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }
}