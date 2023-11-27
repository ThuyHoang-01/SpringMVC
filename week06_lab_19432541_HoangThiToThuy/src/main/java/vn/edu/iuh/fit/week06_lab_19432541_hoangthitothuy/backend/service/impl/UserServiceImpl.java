package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.User;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.repository.UserRepository;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.UserService;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userService;

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userService.findById(id);
    }

    @Override
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @Override
    public boolean login(String email, String password) {
        User user = userService.findByUEmail(email, password);
        return user != null;
    }

    @Override
    public User findByUEmail(String email) {
        return userService.findByEmail(email);
    }
}
