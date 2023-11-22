package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

}
