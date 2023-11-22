package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "product_price")
@Data
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;

    @Column(name = "price")
    private long price;

    @Column(name = "note")
    private String note;
}
