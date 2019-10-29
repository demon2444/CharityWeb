package pl.coderslab.charity.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

   /* @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }*/

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid User user, BindingResult result) {
    if(user.getPassword().equals(user.getPassword2()) && !result.hasErrors()) {
        userService.saveUser(user);
        return "redirect:/login#log";
    } else {

        return "register";
    }
    }

    //todo stworzyc role admin z pomocą save

    @GetMapping("/settings")
    public String profile(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();

        model.addAttribute("user", user);
        return "settings";
    }
    @PostMapping("/settings")
    public String profile(@ModelAttribute @Valid User user, @AuthenticationPrincipal CurrentUser currentUser, BindingResult result) {
        if(user.getPassword().equals(user.getPassword2()) && !result.hasErrors()) {
          /*  if(user.getPassword().equals("")){
                String passSet = currentUser.getPassword();
                user.setPassword(passSet);
                userService.updateUser(user);
            } else {*/

          //todo pobrać usera z repository po id i zapisać
                userService.saveUser(user);
            //}
            return "redirect:/";
        } else {

            return "register";
        }
    }
}
