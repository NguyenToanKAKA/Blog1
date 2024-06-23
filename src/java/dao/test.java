/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.util.Random;
import model.User;

/**
 *
 * @author ASUS
 */
public class test {

    public static void main(String[] args) {

//        JobseekerDAO jd = new JobseekerDAO();
//        User u = new User("Buiii", "Nhan", "nhanbtde170234@fpt.edu.vn", "Congdeptrai.vn?", 2);
////        jd.insert(u);
////        User u1 = new User("Truong", "van", "n@gmail.com","passs", 2, "","","da nang","",);
//
////        jd.insert(u1);
//
//        Random random = new Random();
//
////        System.out.println(jd.update(u));

        CVDAO cvDao = new CVDAO();
        System.out.println(cvDao.findByEmail("tuan@gmail.com").getCVId());
    
    }

}
