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
public class TypeProduct {
    // tid int auto_increment primary key,
    // tName varchar(50)
    private int tid;
    private String tName;
}
