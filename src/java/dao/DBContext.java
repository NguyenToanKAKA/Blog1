/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBContext {
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return (Connection) DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "findjob2";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    public static void main(String[] args) throws Exception {
        DBContext context = new DBContext();
        System.out.println(context.getConnection());
    }
}


