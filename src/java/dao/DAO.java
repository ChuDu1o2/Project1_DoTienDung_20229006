/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Item;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zoro
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay thong tin toan bo san pham
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    //Lay thong tin account
    public List<Account> getAccount() {
        List<Account> listAcc = new ArrayList<>();
        String query = "select * from Account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listAcc.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
        } catch (Exception e) {

        }

        return listAcc;
    }

    //Ham lay thong tin category
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    // Hàm lấy thong tin sản phẩm theo category ID
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    // CRUD product
    public List<Product> getProductCRUD() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    // Hàm tim san pham theo ten
    public List<Product> SearchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    // Hàm lấy thong tin sản phẩm theo ID
    public Product getProductByID(String id) {
        String query = "select * from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }

        } catch (Exception e) {

        }
        return null;
    }

    // Hàm lấy thong tin Account
    public Account getAccountByID(String aid) {
        String query = "select * from account\n"
                + "where uId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }

        } catch (Exception e) {

        }
        return null;
    }

    // Ham login
    public Account login(String user, String pass) {
        String query = "select * from Account\n"
                + "where [user] like ?\n"
                + "and [pass] like ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    // Ham check account sigin
    public Account checkAccountExitst(String user) {
        String query = "select * from Account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection(); //mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //Ham signup 
    public void signUp(String user, String pass, String fullName, String email) {
        String query = "insert into Account "
                + "values(?,?,?,?,0)";
        try {
            conn = new DBContext().getConnection(); //mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, user);
            ps.setString(4, pass);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    //Lay thong tin san pham cuoi cung
    public Product getLast() {
        String query = "select top 1 * from Product\n"
                + "order by id desc";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {

        }
        return null;
    }

    //insert product
    public void insertProduct(String name, String image, String price,
            String title, String description, String category, String quantity) {
        String query = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description], [cateID],[quantity])\n"
                + "VALUES(?,?,?,?,?,?,?)";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, quantity);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    //sua san pham
    public void editProduct(String name, String image, String price,
            String title, String description, String category, String quantity, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?,\n"
                + "quantity = ?\n"
                + "where id = ?";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, quantity);
            ps.setString(8, pid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    //Edit Account
    public void editAccount(String fullName, String email, String user,
            String pass, String id) {
        String query = "update Account\n"
                + "set [fullName] = ?,\n"
                + "[email] = ?,\n"
                + "[user] = ?,\n"
                + "[pass] = ?\n"
                + "where uID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, user);
            ps.setString(4, pass);
            ps.setString(5, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    // Ham delete san pham
    public void deleteProduct(String pid) {
        String query = "delete from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    // Ham delete Account
    public void deleteAccount(String aid) {
        String query = "delete from account\n"
                + "where uID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, aid);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    // insert oder
    
    
    
//test
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Product> list = dao.getAllProduct();
//        for (Product o : list) {
//            System.out.println(o);
//        }
//    }
//test Account
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Account> listAcc = dao.getAccount();
//        for (Account o : listAcc) {
//            System.out.println(o);
//        }
//    }
//test Category
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Category> list = dao.getAllCategory();
//        for (Category o : list) {
//            System.out.println(o);
//        }
//    }
    //test detail
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        Product p = dao.getProductByID("1030");
//        
//            System.out.println(p);
//        
//    }
    //test account
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        Account a = dao.login("Adam", "123456");
//
//        System.out.println(a);
//
//    }
}
