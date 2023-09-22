package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private int product_id;
    private int quantity;
    private double price;
}
