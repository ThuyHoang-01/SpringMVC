package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.PostComment;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.PostCommentService;

import java.util.Optional;

@Component
public class PostCommentServiceImpl implements PostCommentService {
    @Autowired
    private PostCommentRepository postCommentService;

    @Override
    public PostComment save(PostComment postComment) {
        return postCommentService.save(postComment);
    }

    @Override
    public Optional<PostComment> findById(long id) {
        return postCommentService.findById(id);
    }

    @Override
    public void deleteById(long id) {
         postCommentService.deleteById(id);
    }
}
