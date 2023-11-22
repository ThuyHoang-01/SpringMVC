package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int com_id;
    private String about;
    private String comp_name;

    @OneToMany(mappedBy = "com_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Candidate> candidates;

    public Company(int com_id, String about, String comp_name) {
        this.com_id = com_id;
        this.about = about;
        this.comp_name = comp_name;

    }

    public Company(String about, String comp_name) {
        this.about = about;
        this.comp_name = comp_name;
    }


}
