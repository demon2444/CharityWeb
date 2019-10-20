package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/form")
public class DonationController {

    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;


    @Autowired
    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping("")
    public String form(Model model) {
        List<Category> categories = categoryService.findAllcategories();
        Donation donation = new Donation();
        List<Institution> institutions = institutionService.findAll();


        model.addAttribute("donations", donation);
        model.addAttribute("cat", categories);
        model.addAttribute("institutions", institutions);
        return "form";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute @Valid Donation donation, @AuthenticationPrincipal CurrentUser user, BindingResult result) {
      //donation.setCategories();
        User userSave = user.getUser();
        donation.setUser(userSave);
        List<ObjectError> erro = result.getAllErrors();
        if(result.hasErrors()){
            System.err.println(erro);
            return "form";
        }
        else {
            donationService.donationSave(donation);
            return "form-confirmation";
        }
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal CurrentUser currentUser, Model model) {

        return "profile";
    }

    //todo na button w js
    //todo jest widok w załączeniach, formularz w jednej stronie przekazywanie wszystkiego za pomocą jednego formularza podzielonego na części
    //
}
