package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
