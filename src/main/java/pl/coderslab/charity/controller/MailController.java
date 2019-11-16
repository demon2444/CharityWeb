package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.mail.MailService;
import pl.coderslab.charity.model.Email;

@Controller
@RequestMapping("/mail")
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/send")
    public String send(Model model) {
        Email email = new Email();
        model.addAttribute("email", email);
        return "send";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Email email) {
        mailService.reciveSimpleMessage(email.getTitle(), email.getText(), email.getReply());
        return "index";
    }



    @PostMapping("/contact")
    public String contact(@ModelAttribute String reply, @ModelAttribute String title,  @ModelAttribute String message) {
        Email email = new Email("charity.donation12@gmail.com", title, message, reply);
        return "index";
    }

}



