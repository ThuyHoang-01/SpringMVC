package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int pro_id;
     private String name;
     private  String type;
     @ManyToOne
     private  Category category;



}
