package com.example.SpringBootBai1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    // uid int,
    // pid int,
    // primary key (uid, pid),
    // foreign key(uid) references users(uid),
    // foreign key(pid) references product(pid),
    // quantity int,
    // totalprice double
    private int oid;
    private User user;
    private Product product;
    private int quantity;
    private double totalPrice;
}
