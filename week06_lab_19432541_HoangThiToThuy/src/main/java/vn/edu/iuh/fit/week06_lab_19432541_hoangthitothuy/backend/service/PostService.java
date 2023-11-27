package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.Post;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    public List<Post> findAll();
    public Post save(Post post);

    public Optional<Post> findById(long id);

    public void deleteById(long id);
}
