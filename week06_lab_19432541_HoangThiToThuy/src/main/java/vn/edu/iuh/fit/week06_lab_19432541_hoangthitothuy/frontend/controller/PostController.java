package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.frontend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.Post;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.User;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.PostService;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.UserService;

import java.util.List;

@Controller
public class PostController {


    @Autowired
    private PostService postService;


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listPost(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/post/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "post-add";
    }

    @PostMapping("/post/add")
    public String addPostHanddle(@ModelAttribute("post") Post post, HttpServletRequest request) {
        Object messages = request.getSession().getAttribute("email");
        User user = userService.findByUEmail(messages.toString());
        post.setAuthor(user);
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/delete/{id}")
    public String addPostHanddle(@PathVariable("id") long id) {
        postService.deleteById(id);
        return "redirect:/";
    }
}
