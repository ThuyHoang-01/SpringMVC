package vn.edu.iuh.fit.backend.models;


import jakarta.persistence.*;
import lombok.Data;
import vn.edu.iuh.fit.backend.enums.ProductStatusEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String unit;

    @Column
    private String manufacturer_name;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private ProductStatusEnum status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> listProductImage = new ArrayList<ProductImage>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
}
