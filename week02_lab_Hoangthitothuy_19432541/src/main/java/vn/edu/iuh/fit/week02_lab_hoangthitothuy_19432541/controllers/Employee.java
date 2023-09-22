package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.controllers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    private String full_name;
    private String dob;
    private String email;
    private String phone;
    private String address;
    private int status;



}
