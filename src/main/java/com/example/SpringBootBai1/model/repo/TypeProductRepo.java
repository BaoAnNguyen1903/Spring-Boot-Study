package com.example.SpringBootBai1.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


import com.example.SpringBootBai1.model.entity.TypeProduct;

@Repository
public class TypeProductRepo {
    public ArrayList<TypeProduct> getAllTypeProduct() throws Exception{
        ArrayList<TypeProduct> typeProductList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from TypeProduct");
        while (rs.next()) {
            int tid = rs.getInt("tid");
            String tName = rs.getString("tName");
            TypeProduct typeProduct = new TypeProduct(tid, tName);
            typeProductList.add(typeProduct);
        }
        return typeProductList;
    }

    public TypeProduct getTypeProductByProductId(int tid) throws Exception{
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from TypeProduct where tid = ?");
        ps.setInt(1, tid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int tid1 = rs.getInt("tid");
        String tName = rs.getString("tName");
        TypeProduct typeProduct = new TypeProduct(tid1, tName);
        return typeProduct;
    }
}
