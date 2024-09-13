package com.example.SpringBootBai1.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpringBootBai1.model.entity.Order;
import com.example.SpringBootBai1.model.entity.Product;
import com.example.SpringBootBai1.model.entity.User;

@Repository
public class OrderRepo {
    UserRepo userRepo = new UserRepo();
    ProductRepo productRepo = new ProductRepo();

    public ArrayList<Order> getAllOrderByUserId(int uid) throws Exception{
        ArrayList<Order> OrderList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from `order` where uid = ?");
        ps.setInt(1, uid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int oid = rs.getInt("oid");
            int idUser = rs.getInt("uid");
            int idProduct = rs.getInt("pid");
            User user = userRepo.getUserById(idUser);
            Product product = productRepo.getProductBypid(idProduct);
            int quantity = rs.getInt("quantity");
            double totalprice = rs.getDouble("totalprice");
            Order order = new Order(oid, user, product, quantity, totalprice);
            OrderList.add(order);
        }
        return OrderList;
    }

    public ArrayList<Order> getAllOrder() throws Exception{
        ArrayList<Order> OrderList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from `order`"); // Query la Xem du lieu, Update la Add,Delete,Update
        while (rs.next()) {
            int oid = rs.getInt("oid");
            int idUser = rs.getInt("uid");
            int idProduct = rs.getInt("pid");
            User user = userRepo.getUserById(idUser);
            Product product = productRepo.getProductBypid(idProduct);
            int quantity = rs.getInt("quantity");
            double totalprice = rs.getDouble("totalprice");
            Order order = new Order(oid, user, product, quantity, totalprice);
            OrderList.add(order);
        }
        return OrderList;
    }
    public void addNewOrder(Order oder) throws Exception{
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO `order` (uid, pid, quantity, totalprice) VALUES (?,?,?,?)");
        ps.setInt(1, oder.getUser().getUid());
        ps.setInt(2, oder.getProduct().getPid());
        ps.setInt(3, oder.getQuantity());
        ps.setDouble(4, oder.getTotalPrice());
        ps.executeUpdate();
    }
}
