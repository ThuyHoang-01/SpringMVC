package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_image")
@Data
public class ProductImage {

    @Id
    @Column(name = "image_id")
    private long imageId;

    @Column
    private String path;

    @Column
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
