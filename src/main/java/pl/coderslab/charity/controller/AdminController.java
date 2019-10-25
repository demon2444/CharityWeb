package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.service.UserServiceImpl;

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

    @GetMapping("/loginAdmin")
    public String loginAdmin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginAdmin";
    }

    @GetMapping("")
    public String panel() {
        return "panel";
    }



}
