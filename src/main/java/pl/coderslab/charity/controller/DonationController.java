package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
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
        User userSave = user.getUser();
        donation.setUser(userSave);
        donation.setPicked(false);
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
        Long userId = currentUser.getUser().getId();
        Long countBags = donationService.countAllBags(userId);
        Long countInstitutions = donationService.countInstitutions(userId);
        model.addAttribute("bags", countBags);
        model.addAttribute("institutions", countInstitutions);

        return "profile";
    }


    @GetMapping("/my")
    public String myDonations(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Long id = currentUser.getUser().getId();
        List<Donation> donations = donationService.findAllOrderById(id);
        model.addAttribute("donations", donations);
        return "my-donations";
    }

    @GetMapping("/done/{id}")
    public String pickedUp(@PathVariable Long id, @AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Donation donation = donationService.findDonationById(id);
        donation.setPicked(true);
        donation.setPickedOn();
        donationService.donationSave(donation);
        Long userId = currentUser.getUser().getId();
        List<Donation> donations = donationService.findAllOrderById(userId);
        model.addAttribute("donations", donations);
        return "my-donations";
    }

    @GetMapping("/time")
    public String timeSorted(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Long id = currentUser.getUser().getId();
        List<Donation> donations = donationService.findAllOrderByPickedOn(id);
        model.addAttribute("donations", donations);
        return "my-donations";
    }

    @GetMapping("/picked")
    public String pickedSorted(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Long id = currentUser.getUser().getId();
        List<Donation> donations = donationService.findAllSortedByIsPicked(id);
        model.addAttribute("donations", donations);
        return "my-donations";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Donation donation = donationService.findDonationById(id);
        model.addAttribute("donation", donation);
        return "details";
    }

}
