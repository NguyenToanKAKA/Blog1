/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Comment;
import java.sql.Date;
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
public class CommentDAO extends DBContext implements BaseDAO<Comment> {

     public int getCountByBlog(int blogId) {
        int result = 0;
        String sql = "SELECT COUNT(*) FROM Comments WHERE BlogID = ? ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, blogId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public List<Comment> getAllLoadMore(int blogId) {
        List<Comment> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Comments \n"
                    + "WHERE BlogID = ? \n";

            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, blogId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(
                        rs.getInt("CommentID"),
                        rs.getInt("UserID"),
                        rs.getInt("BlogID"),
                        rs.getString("CommentText"),
                        rs.getString("CommentDate")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public boolean insert(Comment cmt) {
        String sql = "INSERT INTO [dbo].[Comments]\n"
                + "           ([UserID]\n"
                + "           ,[BlogID]\n"
                + "           ,[CommentText]\n"
                + "           ,[CommentDate]) \n"
                + "     VALUES \n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, cmt.getUserId());
            st.setInt(2, cmt.getBlogId());
            st.setString(3, cmt.getContent());
            java.util.Date date = new java.util.Date();
            long mi = date.getTime();
            Date d = new Date(mi);
            st.setDate(4, d);

            int rowAffect = st.executeUpdate();
            if (rowAffect > 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Comment newObject) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    
    
    public boolean deleteComment(int commentId) {
        String sql = "DELETE FROM Comments WHERE CommentID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, commentId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true; // Xóa thành công
            }
        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Xóa không thành công
    }
    
    public boolean updateStatus(int commentId, String status) {
    String sql = "UPDATE Comments SET Status = 'Report' WHERE CommentID = ?";
    try {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setInt(1, commentId);

        int rowsUpdated = ps.executeUpdate();
        return rowsUpdated > 0;
    } catch (Exception ex) {
        Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}

    @Override
    public String getRoleByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comment findByEmail(String email) {
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
