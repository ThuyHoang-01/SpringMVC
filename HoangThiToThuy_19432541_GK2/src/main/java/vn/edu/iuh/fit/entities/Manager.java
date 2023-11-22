package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ma_id;
    private String name;
    private String level;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Manager(int id,String name, String level) {
        this.ma_id = id;
        this.name = name;
        this.level = level;
    }
    public Manager(String name, String level) {

        this.name = name;
        this.level = level;
    }
}
