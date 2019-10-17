package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller

public class HomeController {

    private InstitutionService institutionService;
    private DonationService donationService;

    @Autowired
    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }





    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionsFirst = institutionService.findAllFirstHalf();
        List<Institution> institutionsSecond = institutionService.findAllSecondHalf();

        User user = new User();
        user.setId(null);
        model.addAttribute("user", user);

        Long quantitySum = donationService.sumQuantity();
        Long donateInstitutions = donationService.donateInstitutions();

        model.addAttribute("quantitySum", quantitySum);
        model.addAttribute("donateInstitutions", donateInstitutions);
        model.addAttribute("institutionsFirst", institutionsFirst);
        model.addAttribute("institutionsSecond", institutionsSecond);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }



}
