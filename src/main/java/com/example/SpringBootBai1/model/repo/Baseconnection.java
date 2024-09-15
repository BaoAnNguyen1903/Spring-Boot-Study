package com.example.SpringBootBai1.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baseconnection {
    static String url = "jdbc:mysql://localhost:3306/banhangmvc";
    static String username = "root";
    static String password = "0987689426Ba#";
static String nameClass = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/banhangmvc";
        String username = "root";
        String password = "0987689426Ba#";
        // Kết nối tới cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
