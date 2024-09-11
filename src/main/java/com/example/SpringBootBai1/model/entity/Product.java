package com.example.SpringBootBai1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    // pid int auto_increment primary key,
    // pName varchar(50),
    // tid int,
    // foreign key (tid) references TypeProduct(tid),
    // price double,
    // quantity int,
    // img text
    private int pid;
    private String pName;
    private TypeProduct typeProduct;
    private double price;
    private int quantity;
    private String img;
}
