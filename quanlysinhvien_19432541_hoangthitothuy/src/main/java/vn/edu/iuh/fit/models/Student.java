package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_student;

    private String name;

    private int old;

    @ManyToOne
    @JoinColumn(name = "teacher_id")

    private Teacher teacher;



}
