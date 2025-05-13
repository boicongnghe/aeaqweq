
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT
 */
public class test {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
