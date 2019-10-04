package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionService institutionService;

    @Autowired
    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }





    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionsFirst = institutionService.findAllFirstHalf();
        List<Institution> institutionsSecond = institutionService.findAllSecondHalf();

        model.addAttribute("institutionsFirst", institutionsFirst);
        model.addAttribute("institutionsSecond", institutionsSecond);
        return "index";
    }




}
