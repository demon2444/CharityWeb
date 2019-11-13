package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.mail.MailService;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;
    private MailService mailService;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder, MailService mailService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
    }



    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid User user, BindingResult result) {
    if(user.getPassword().equals(user.getPassword2()) && !result.hasErrors()) {
        user.setToken(userService.generateUUID());
        user.setEnabled(false);

        userService.saveUser(user);
        User userEmail = userService.findByUsername(user.getUsername());

        String text = "http://localhost/user/activate/"+userEmail.getId()+"/"+userEmail.getToken();
        mailService.sendSimpleMessage(user.getUsername(), "Link aktywacyjny", text);

        return "redirect:/login#log";
    } else {

        return "register";
    }
    }

    @GetMapping("/activate/{id}/{token}")
    public String activate(@PathVariable Long id, @PathVariable String token){
        User user = userService.findUserById(id);
        if(user.getToken().equals(token)){

            user.setEnabled(true);

            return "activate";

        }
        else return "notAcitvate";


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
