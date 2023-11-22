package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_detail")
@IdClass(OrderDetailPK.class)
@Data
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private int quantity;

    @Column
    private double price;
}
