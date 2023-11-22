package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int can_id;
    private String email;
    private  String full_name;


    @ManyToOne
    @JoinColumn(name = "com_id")

    private Company company;

    public Candidate( String email, String full_name, Company company) {
        this.email = email;
        this.full_name = full_name;
        this.company = company;
    }

}
