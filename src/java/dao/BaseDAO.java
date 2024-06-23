/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author ASUS
 */
 interface BaseDAO<T> {
     
    String getRoleByEmail(String email);
     
    T findByEmail(String email);

    List<T> getAll();

    T findById(int id);

    boolean insert(T newObject);

    boolean update(T newObject);

    boolean delete(int id);
    
    boolean updateUserFromCV(String email, String  firstName, String lastName, String phoneNumber,String newEmail, String city);
    
    boolean updateCVProfileFromCV(String avatar, String  education, String skills, String experience,
            String certification, String description, String linkUrl, String email);

    
    
}
