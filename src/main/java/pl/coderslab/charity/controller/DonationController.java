package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

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


        model.addAttribute("categories", categories);
        return "form";
    }

    @PostMapping("/confirm")
    public String confirm(Model model) {
        return "from-confirmation";
    }
    //todo na button w js
    //todo jest widok w załączeniach, formularz w jednej stronie przekazywanie wszystkiego za pomocą jednego formularza podzielonego na części
    //
}
