package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String send(@ModelAttribute String title, @ModelAttribute String text) {
        mailService.reciveSimpleMessage(title, text);
        return "index";
    }


}



