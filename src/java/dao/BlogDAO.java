/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import model.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author This PC
 */
public class BlogDAO extends DBContext implements BaseDAO<Blog> {

    private static final int RECORDS_PER_PAGE = 4;
    private static final int RECORDS_PER_PAGE_MANAGERBLOG = 3;
    public int getNoOfBlogs() {
        int noOfBlogs = 0;
        String sql = "SELECT COUNT(*) FROM Blogs WHERE [Status] = 'Accept' ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                noOfBlogs = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfBlogs;
    }
    
    public List<Blog> getAllBlogsPaging(int page) {
        List<Blog> list = new ArrayList<>();
        int start = (page-1) * RECORDS_PER_PAGE;
        try {
            String sql = "SELECT * FROM Blogs \n"
                    + "WHERE [Status] = 'Accept' \n"
                    + "ORDER BY BlogID \n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";

            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, RECORDS_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(
                        rs.getInt("BlogID"),
                        rs.getInt("UserID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("PublishDate"),
                        rs.getString("Image"),
                        rs.getString("Status")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public List<Blog> getAll() {
        return null;
    }

    @Override
    public Blog findById(int id) {
        String sql = "SELECT * FROM Blogs \n"
                + "WHERE BlogID = ? AND Status = 'Accept' ";
        Blog blog = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                blog = new Blog(
                        rs.getInt("BlogID"),
                        rs.getInt("UserID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("PublishDate"),
                        rs.getString("Image"),
                        rs.getString("Status")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blog;
    }

    @Override
    public boolean insert(Blog newObject) {
        return false;
    }

    @Override
    public boolean update(Blog newObject) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    
    public int getNoOfBlogsByUserId(int userId) {
        int noOfBlogs = 0;
        String sql = "SELECT COUNT(*) FROM Blogs WHERE UserID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                noOfBlogs = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfBlogs;
    }

    public List<Blog> getProductsBySellId(int Id, int page) {
        List<Blog> list = new ArrayList<>();
        int start = (page - 1) * RECORDS_PER_PAGE_MANAGERBLOG;
        try {
            String sql = "SELECT * FROM Blogs WHERE UserID = ? ORDER BY BlogID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, Id);
            stm.setInt(2, start);
            stm.setInt(3, RECORDS_PER_PAGE_MANAGERBLOG);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog product = new Blog();
                product.setBlogId(rs.getInt(1));
                product.setUserId(rs.getInt(2));
                product.setTitle(rs.getString(3));
                product.setContent(rs.getString(4));
                product.setDate(rs.getString(5));
                product.setImage(rs.getString(6));
                product.setStatus(rs.getString(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void inSertProduct(Blog blog) {
    try {
      String sql = "INSERT INTO Blogs (UserID, Title, Content,Image, Status) " +
                   "VALUES (?, ?, ?,?, 'Pending')";

      PreparedStatement stm = getConnection().prepareStatement(sql);
      stm.setInt(1, blog.getUserId());
      stm.setString(2, blog.getTitle());
      stm.setString(3, blog.getContent());
      stm.setString(4, blog.getImage());
      stm.executeUpdate();
  } catch (Exception ex) {
      Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
  }
}
    
   public void updateBlog(Blog b) {
    try {
        String sql = "UPDATE Blogs\n"
                   + "   SET Title = ?,\n"
                   + "       Content = ?,\n"
                   + "       Image = ?,\n"
                   + "       Status = 'Pending'\n"  // Set Status to 'Pending'
                   + " WHERE BlogID = ?";
        PreparedStatement stm = getConnection().prepareStatement(sql);
        stm.setString(1, b.getTitle());
        stm.setString(2, b.getContent());
        stm.setString(3, b.getImage()); // Assuming getImage() returns the image file name
        stm.setInt(4, b.getBlogId());
        stm.executeUpdate();
    } catch (Exception ex) {
        Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public Blog getBlogById(int blogId) {
    try {
        String sql = "SELECT * FROM Blogs WHERE BlogID = ?";
        PreparedStatement stm = getConnection().prepareStatement(sql);
        stm.setInt(1, blogId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Blog blog = new Blog();
            blog.setBlogId(rs.getInt("BlogID"));
            blog.setUserId(rs.getInt("UserID"));
            blog.setTitle(rs.getString("Title"));
            blog.setContent(rs.getString("Content"));
            blog.setDate(rs.getString("PublishDate"));
            blog.setImage(rs.getString("Image"));
            blog.setStatus(rs.getString("Status"));
            return blog;
        }
    } catch (Exception ex) {
        Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
    
    public List<Blog> getTop3BlogsByLikes() {
    List<Blog> top3Blogs = new ArrayList<>();
    try {
        String sql = "SELECT TOP 3 b.*, COUNT(l.BlogID) AS LikeCount " +
                     "FROM Blogs b " +
                     "LEFT JOIN Likes l ON b.BlogID = l.BlogID " +
                     "WHERE b.Status = 'Accept' " +
                     "GROUP BY b.BlogID, b.UserID, b.Title, b.Content, b.PublishDate, b.Image, b.Status " +
                     "ORDER BY LikeCount DESC";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Blog blog = new Blog(
                    rs.getInt("BlogID"),
                    rs.getInt("UserID"),
                    rs.getString("Title"),
                    rs.getString("Content"),
                    rs.getString("PublishDate"),
                    rs.getString("Image"),
                    rs.getString("Status")
            );
            top3Blogs.add(blog);
        }
    } catch (Exception ex) {
        Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return top3Blogs;
}
    public List<Blog> searchBlogs(String keyword) {
    List<Blog> result = new ArrayList<>();
    try {
        String sql = "SELECT * FROM Blogs WHERE [Status] = 'Accept' AND Title = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1, keyword);  // Không cần thêm dấu '%' vì đây là tìm kiếm chính xác
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Blog blog = new Blog(
                    rs.getInt("BlogID"),
                    rs.getInt("UserID"),
                    rs.getString("Title"),
                    rs.getString("Content"),
                    rs.getString("PublishDate"),
                    rs.getString("Image"),
                    rs.getString("Status")
            );
            result.add(blog);
        }
    } catch (Exception ex) {
        Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}

    public List<Blog> getAcceptedBlogsByUserId(int userId) {
        List<Blog> acceptedBlogs = new ArrayList<>();
        String sql = "SELECT * FROM Blogs WHERE Status = 'Accept' AND UserID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog(
                        rs.getInt("BlogID"),
                        rs.getInt("UserID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("PublishDate"),
                        rs.getString("Image"),
                        rs.getString("Status")
                );
                acceptedBlogs.add(blog);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acceptedBlogs;
    }
    
    // Phương thức lấy danh sách các bài viết có trạng thái 'Reject' theo UserID
    public List<Blog> getRejectBlogsByUserId(int userId) {
        List<Blog> rejectedBlogs = new ArrayList<>();
        String sql = "SELECT * FROM Blogs WHERE Status = 'Reject' AND UserID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog(
                        rs.getInt("BlogID"),
                        rs.getInt("UserID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("PublishDate"),
                        rs.getString("Image"),
                        rs.getString("Status")
                );
                rejectedBlogs.add(blog);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rejectedBlogs;
    }
    // Phương thức lấy danh sách các bài viết có trạng thái 'Pending' theo UserID
    public List<Blog> getPendingBlogsByUserId(int userId) {
        List<Blog> pendingBlogs = new ArrayList<>();
        String sql = "SELECT * FROM Blogs WHERE Status = 'Pending' AND UserID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog(
                        rs.getInt("BlogID"),
                        rs.getInt("UserID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("PublishDate"),
                        rs.getString("Image"),
                        rs.getString("Status")
                );
                pendingBlogs.add(blog);
            }
        } catch (Exception ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pendingBlogs;
    }

    @Override
    public String getRoleByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Blog findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateUserFromCV(String email, String firstName, String lastName, String phoneNumber, String newEmail, String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateCVProfileFromCV(String avatar, String education, String skills, String experience, String certification, String description, String linkUrl, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
