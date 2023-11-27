package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.Post;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.repository.PostRepository;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.PostService;

import java.util.List;
import java.util.Optional;

@Component
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postService;

    @Override
    public List<Post> findAll() {
        return postService.findAll();
    }

    @Override
    public Post save(Post post) {
        return postService.save(post);
    }

    @Override
    public Optional<Post> findById(long id) {
        return postService.findById(id);
    }

    @Override
    public void deleteById(long id) {
         postService.deleteById(id);
    }
}
