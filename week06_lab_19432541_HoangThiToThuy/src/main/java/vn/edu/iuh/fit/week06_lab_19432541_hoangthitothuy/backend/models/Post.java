package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true, length = 100)
    private String metaTitle;

    @Column(nullable = true, columnDefinition = "TINYTEXT")
    private String summary;

    @Column(nullable = true, columnDefinition = "TINYTEXT")
    private String published;

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime publishedAt;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "authorId", nullable = false)
    private User author;

    @ManyToOne()
    @JoinColumn(name = "parentId", nullable = true)
    private Post parent;

    @OneToMany(mappedBy = "post")
    private List<PostComment> postComments;
}
