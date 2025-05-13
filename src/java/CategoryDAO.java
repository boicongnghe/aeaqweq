/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author vanmi
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getAll() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "select * from [Categories]";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String describe = rs.getString("describe");

                categories.add(new Category(id, name, describe));
            }
            return categories;

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Category getOne(int cid) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Category category = null;
        String sql = "select * from [Categories] where id = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String describe = rs.getString("describe");

                category = new Category(id, name, describe);
            }
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insert(Category category) {
        PreparedStatement stm = null;
        int result = -1;
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([ID]\n"
                + "           ,[name]\n"
                + "           ,[describe])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, category.getId());
            stm.setString(2, category.getName());
            stm.setString(3, category.getDescribe());

            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int update(Category category) {
        PreparedStatement stm = null;
        int result = -1;
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [ID] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[describe] = ?\n"
                + " WHERE ID = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, category.getId());
            stm.setString(2, category.getName());
            stm.setString(3, category.getDescribe());
            stm.setInt(4, category.getId());

            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(int cid) {
        PreparedStatement stm = null;
        int result = -1;
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE ID = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);

            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();

//        ArrayList<Category> list = categoryDAO.getAll();
//        
//        for (Category c : list) {
//            System.out.println(c);
//        }
//        Category category = categoryDAO.getOne(10);
//        System.out.println(category);
//        Category category = new Category(6, "Huawei", "Huawei");
//        int result = categoryDAO.insert(category);
//
//        if (result == -1 || result == 0) {
//            System.out.println("Insert fail");
//        } else {
//            System.out.println("Insert successul");
//        }
//        Category category = new Category(7, "Redmi", "Redmi");
//        int result = categoryDAO.update(category);
//
//        if (result == -1 || result == 0) {
//            System.out.println("UPDATE fail");
//        } else {
//            System.out.println("UUPDATE successul");
//        }
        int result = categoryDAO.delete(6);

        if (result == -1 || result == 0) {
            System.out.println("delete fail");
        } else {
            System.out.println("delete successul");
        }
    }
}
