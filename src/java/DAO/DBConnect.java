/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author FPT
 */
public class DBConnect {
    DBConnect luom=new DBConnect();
    Connection conn=luom.connect();
    String sql = "select * from Human";
    PreparedStatement stmt=conn.prepareStatement(sql);
    ResultSet out=stmt.executeQuery();
    
}
