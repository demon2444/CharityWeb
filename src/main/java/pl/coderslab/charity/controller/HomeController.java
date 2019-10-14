package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

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




}
