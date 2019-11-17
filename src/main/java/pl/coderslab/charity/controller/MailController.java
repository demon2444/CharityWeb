package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.mail.MailService;
import pl.coderslab.charity.model.Email;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {

    private MailService mailService;
    private UserService userService;

    @Autowired
    public MailController(MailService mailService, UserService userService) {

        this.mailService = mailService;
        this.userService = userService;
    }

    @GetMapping("/send")
    public String send(Model model) {
        Email email = new Email();
        List<String> usersnames = userService.getAllUsersNames();
        email.setUsers(usersnames);
        model.addAttribute("email", email);
        return "send";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Email email) {
        mailService.reciveSimpleMessage(email.getTitle(), email.getText(), email.getReply());
        return "index";
    }



    @PostMapping("/contact")
    public String contact(@RequestParam String to, String reply, String title, String message) {
        Email email = new Email(to , title, message, reply);
        mailService.emailContact(email);
        return "redirect:/";
    }

}



