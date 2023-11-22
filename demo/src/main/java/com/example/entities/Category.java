package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cate_id;
    private String name;
    private  String address;


    @OneToMany(mappedBy = "categpry", cascade = CascadeType.ALL)
    private List<Product> products;

}
