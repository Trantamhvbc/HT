/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;

/**
 *
 * @author Duong
 */
public class DAO {

    protected static Connection con = null;

    public DAO() {

        if (con == null) {


            try {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                con = DriverManager.getConnection(dbURL, user, pass);
                con = HikariCPDataSource.getConnection();
                // Code here.
            } // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Connection getCon() {
        return con;
    }
    
//     public Connection getCon() {
//        try {
//            if (con.isClosed()) {
//                try {
//                    con = HikariCPDataSource.getConnection();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql2 = "select * from taikhoan";
        String sql1="insert into nhacungcap (ten,email,sodienthoai) values ('a','b','c')";
        try {
            con = HikariCPDataSource.getConnection();
            stm = con.prepareStatement(sql1);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
