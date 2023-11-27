package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comment")
@Data
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true, columnDefinition = "TINYTEXT")
    private String published;

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime publishedAt;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "parentId", nullable = false)
    private PostComment parent;
}
