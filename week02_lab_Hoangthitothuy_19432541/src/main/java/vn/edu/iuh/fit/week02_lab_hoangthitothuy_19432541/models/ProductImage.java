package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_image")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int imgage_id;

    private String path;
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
