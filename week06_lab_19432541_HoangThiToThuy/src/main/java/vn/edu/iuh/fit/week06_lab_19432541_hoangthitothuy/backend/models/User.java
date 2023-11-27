package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( nullable = false)
    private String firstName;

    @Column( nullable = true)
    private String middleName;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = true)
    private String mobile;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String passwordHash;

    @Column(nullable = true)
    @CreationTimestamp
    private LocalDateTime registeredAt;

    @Column(nullable = true)
    private LocalDateTime lastLogin;

    @Column(nullable = true, columnDefinition = "TINYTEXT")
    private String intro;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String profile;

    @OneToMany(mappedBy = "author")
    private List<Post> post;

}
