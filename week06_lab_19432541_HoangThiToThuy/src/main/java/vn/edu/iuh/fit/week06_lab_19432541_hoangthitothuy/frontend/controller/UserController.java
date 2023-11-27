package vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.frontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.Post;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.models.User;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.PostService;
import vn.edu.iuh.fit.week06_lab_19432541_hoangthitothuy.backend.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("email") String email, HttpSession session, @ModelAttribute("password") String password, Model model) {

        boolean check = userService.login(email, password);

        if(check == false){
            model.addAttribute("err", "error");
            return "redirect:/login";
        }else{
        session.setAttribute("email", email);
        return "redirect:/";
        }
    }

}
