package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.controllers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
    public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private String description;
    private int unit;
    private String manufacturer_name;
    private int status;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductImage> images = new ArrayList<>();

    public Product(int product_id, String name, String description, int unit, String manufacturer_name, int status) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
    }
}
