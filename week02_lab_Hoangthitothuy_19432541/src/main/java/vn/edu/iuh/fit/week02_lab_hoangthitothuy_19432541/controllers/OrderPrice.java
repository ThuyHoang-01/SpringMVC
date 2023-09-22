package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.controllers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_price")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String price_date_time;
    private double price;
    private String note;

}

