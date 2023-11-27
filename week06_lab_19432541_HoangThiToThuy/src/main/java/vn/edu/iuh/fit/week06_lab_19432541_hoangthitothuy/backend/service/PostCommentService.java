package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.PostComment;

import java.util.Optional;

@Service
public interface PostCommentService {
    public PostComment save(PostComment postComment);

    public Optional<PostComment> findById(long id);

    public void deleteById(long id);
}
