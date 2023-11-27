package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.User;

import java.util.Optional;

@Service
public interface UserService {
    public User save(User user);

    public Optional<User> findById(long id);

    public void deleteById(long id);

    public boolean login( String username, String password);

    public User findByUEmail(String email);
}
