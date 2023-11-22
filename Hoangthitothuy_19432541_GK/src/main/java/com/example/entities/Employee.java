package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    private String name;
    private String old;

    @ManyToOne
    @JoinColumn(name = "ma_id")
    private Manager manager;

    public Employee(String name, String old, Manager manager) {
        this.name = name;
        this.old = old;
        this.manager = manager;
    }
}
