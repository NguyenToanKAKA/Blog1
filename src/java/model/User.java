/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class User {
    
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int roleId;
    private String message;
    private String status;
    private String cityName;
    private String phoneNumber;
    private Date date;

    public User() {
    }

    public User(int idUser, String firstName, String lastName, String email, String password, int roleId, String message, String status) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
    }

    public User(int idUser, String firstName, String lastName, String email, String password, int roleId, String message, String status, Date date) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
        this.date = date;
    }

    public User(int idUser, String firstName, String lastName, String email, String password, int roleId, String message, String status, String cityName, Date date) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
        this.cityName = cityName;
        this.date = date;
    }

    public User(int idUser, String firstName, String lastName, String email, String password, int roleId, String message, String status, String cityName, String phoneNumber) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
        this.cityName = cityName;
        this.phoneNumber = phoneNumber;
    }

    public User(int idUser, String firstName, String lastName, String email, String password, int roleId, String message, String status, String cityName, String phoneNumber, Date date) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
        this.cityName = cityName;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public User(String firstName, String lastName, String email, String password, int roleId, String message, String status, String cityName, String phoneNumber, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
        this.cityName = cityName;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public User(String firstName, String lastName, String email, String password, int roleId, String message, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
        this.status = status;
    }

    public User(String firstName, String lastName, String email, String password, int roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public User(String firstName, String lastName, String email, int roleId, String status, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", roleId=" + roleId + ", message=" + message + ", status=" + status + ", cityName=" + cityName + ", phoneNumber=" + phoneNumber + ", date=" + date + '}';
    }



}
