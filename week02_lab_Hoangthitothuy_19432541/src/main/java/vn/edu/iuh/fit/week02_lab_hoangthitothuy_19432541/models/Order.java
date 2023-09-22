package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private Date order_date;
    private int emp_id;
}
