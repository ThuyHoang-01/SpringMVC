package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.EmployeeStatusEnum;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatusEnum status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> orders;
}
