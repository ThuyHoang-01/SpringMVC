package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbAnnotation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
@ToString
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_teacher;

    private String name;

    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private List<Student> students;

}
