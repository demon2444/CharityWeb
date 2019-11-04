package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {




    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }



    @GetMapping("/panel")
    public String panel(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "panel";
    }

    @GetMapping("/block/{id}")
    public String change(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        user.setEnabled(false);
        userService.updateUser(user);
        return "panel";
    }



}
