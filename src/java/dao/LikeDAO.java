/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import model.Like;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author This PC
 */
public class LikeDAO extends DBContext implements BaseDAO<Like> {

    public int getCountByBlog(int blogId) {
        int result = 0;
        String sql = "SELECT COUNT(*) FROM Likes WHERE BlogID = ? ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, blogId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(LikeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Like> getAll() {
        return null;
    }

    @Override
    public Like findById(int id) {
        return null;
    }

    @Override
    public boolean insert(Like like) {
        String sql = "INSERT INTO [dbo].[Likes]\n"
                + "           ([UserID]\n"
                + "           ,[BlogID]) \n"
                + "     VALUES \n"
                + "           (?,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, like.getUserId());
            st.setInt(2, like.getBlogId());

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
    public boolean update(Like newObject) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public String getRoleByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Like findByEmail(String email) {
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
