/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class JobseekerDAO extends DBContext implements BaseDAO<User> {

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                int roleID = rs.getInt(6);
                String message = rs.getString(7);
                String city = rs.getString(8);
                String phoneNumber = rs.getString(9);
                Date dob = rs.getDate(10);
                String status = rs.getString(11);
                User u = new User(idUser, firstName, lastName, email, password, roleID, message, status, city, "0" + phoneNumber, dob);
                list.add(u);

            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getInfo(int id) {

        String sql = "SELECT \n"
                + "*\n"
                + "FROM \n"
                + "    Jobs j\n"
                + "JOIN \n"
                + "    CompanyProfile cp ON j.CompanyID = cp.CompanyID\n"
                + "JOIN \n"
                + "    Users u ON cp.UserID = u.UserID\n"
                + "WHERE \n"
                + "    j.JobID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email = rs.getString("Email");
                int userID = rs.getInt("RoleID");
                String phoneNumber = rs.getString("PhoneNumber");
                String status = rs.getString(11);
                User u = new User(firstName, lastName, email, userID, status, "0" + phoneNumber);
                return u;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM Users \n"
                + "Where UserID = ? ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                int roleID = rs.getInt(6);
                String message = rs.getString(7);
                String city = rs.getString(8);
                String phoneNumber = rs.getString(9);
                Date dob = rs.getDate(10);
                String status = rs.getString(11);
                User u = new User(idUser, firstName, lastName, email, password, roleID, message, status, city, phoneNumber, dob);
                return u;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(User newObject) {
        String sql = "Insert Into Users(FirstName,LastName,Email,Password,RoleID,Status)\n"
                + "Values (?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, newObject.getFirstName());
            ps.setString(2, newObject.getLastName());
            ps.setString(3, newObject.getEmail());
            ps.setString(4, newObject.getPassword());
            ps.setInt(5, newObject.getRoleId());
            ps.setString(6, newObject.getStatus());
            int rowAffect = ps.executeUpdate();
            if (rowAffect > 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User fogortPass(String email) {
        String sql = "SELECT * FROM Users\n"
                + "Where Email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                User u = findById(idUser);
                if (u != null) {
                    return u;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean changePass(int idUser, String password) {
        String sql = "Update Users\n"
                + "		set Password = ?\n"
                + "		Where UserID = ?";
        User u = findById(idUser);
        PreparedStatement ps;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, u.getIdUser());

            int rowAffect = ps.executeUpdate();
            if (rowAffect > 0) {

                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public User loginAcount(String email, String pass) {

        String sql = "Select * from Users Where Email =? AND Password = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(11), rs.getString(8), rs.getString(9), rs.getDate(10));
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public boolean update(User newObject) {
        String sql = "Update Users \n"
                + "                set FirstName = ?,\n"
                + "                LastName =?,\n"
                + "                Password = ?, \n"
                + "                City = ?, \n"
                + "                PhoneNumber = ?,\n"
                + "                DateOfBirth = ?\n"
                + "                Where UserID = ?";

        PreparedStatement ps;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, newObject.getFirstName());
            ps.setString(2, newObject.getLastName());
            ps.setString(3, newObject.getPassword());
            ps.setString(4, newObject.getCityName());
            ps.setInt(5, Integer.parseInt(newObject.getPhoneNumber()));
            ps.setDate(6, (Date) newObject.getDate());
            ps.setInt(7, newObject.getIdUser());

            int rowAffect = ps.executeUpdate();
            if (rowAffect > 0) {

                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Cv Task
    public User findByEmail(String email) {
        String sql = "SELECT * FROM Users \n"
                + "Where Email = ? ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String password = rs.getString(5);
                int roleID = rs.getInt(6);
                String message = rs.getString(7);
                String city = rs.getString(8);
                String phoneNumber = rs.getString(9);
                Date dob = rs.getDate(10);
                String status = rs.getString(11);
                User u = new User(idUser, firstName, lastName, email, password, roleID, message, status, city, phoneNumber, dob);
                return u;

            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getRoleByEmail(String email) {
        String sql = "select RoleName from Roles where RoleID = (select RoleID from Users where Email= ?)";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String roleName = rs.getString(1);
                return roleName;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateUserFromCV(String email, String firstName, String lastName, String phoneNumber, String newEmail, String city, Date dob) {
        String sql = "UPDATE Users\n"
                + "SET FirstName = ?,\n"
                + "    LastName = ?,\n"
                + "    PhoneNumber = ?,\n"
                + "    City = ?,\n"
                + "    Email = ?,\n"
                + "    DateOfBirth = ? \n"
                + "WHERE Email = ? ;";
        PreparedStatement ps;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, Integer.parseInt(phoneNumber));
            ps.setString(4, city);
            ps.setString(5, newEmail);
            if (dob != null) {
                ps.setDate(6, dob);
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }
            ps.setString(7, email);

            int rowAffect = ps.executeUpdate();
            if (rowAffect > 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public static void main(String[] args) {
        JobseekerDAO jd = new JobseekerDAO();
        System.out.println(jd.findById(1));
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
