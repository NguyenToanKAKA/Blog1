/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserDTO;


/**
 *
 * @author This PC
 */
public class UserDAO extends DBContext {
    
    public String getFullname(int userId) {
        String fname = null;
        try {
            String sql = "SELECT Email FROM Users \n"
                    + "WHERE UserID = ? \n";

            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fname = rs.getString("Email");
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fname;
    }
    
    public UserDTO getUserById(int userId) {
        UserDTO user = null;
        try {
            String sql = "SELECT u.*, cv.Avatar " +
                         "FROM Users u " +
                         "INNER JOIN CVProfile cv ON u.UserID = cv.UserID " +
                         "WHERE u.UserID = ?";
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setUserId(rs.getInt("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setAvatar(rs.getString("Avatar")); 
                user.setCity(rs.getString("City"));

            }
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public String getAvatarByUserId(int userId) {
        String avatar = null;
        try {
            String sql = "SELECT Avatar FROM CVProfile WHERE UserID = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avatar = rs.getString("Avatar");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avatar;
    }
    
}
