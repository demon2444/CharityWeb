package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;
    private InstitutionService institutionService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, InstitutionService institutionService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.institutionService = institutionService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/panel")
    public String panel(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "panel";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @AuthenticationPrincipal CurrentUser currentUser) {

        Long currentId = currentUser.getUser().getId();
        if (currentId == id) {
            return "deleteError";
        } else {
            userService.deleteUser(id);
            return "redirect:/admin/panel";

        }


    }

    @GetMapping("/change/{id}")
    public String edit(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        Set<Role> roles = user.getRoles();
        boolean isAdmin = false;
        for (Role r : roles) {
            if (r.getName().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }
        if (isAdmin) {
            userService.revokeAdmin(user);
        } else {
            userService.saveAdmin(user);
        }


        return "redirect:/admin/panel";
    }

    @GetMapping("/block/{id}")
    public String change(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        if (user.isEnabled() == true) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userService.updateUser(user);
        return "redirect:/admin/panel";
    }


    @GetMapping("/institutions")
    public String institutions(Model model) {
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("institutions", institutions);
        return "institutions";
    }

    @GetMapping("/institutions/delete/{id}")
    public String delete(@PathVariable Long id) {
        institutionService.delete(id);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/edit/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        Institution institution = institutionService.findById(id);
        model.addAttribute("institution", institution);
        return "addInstution";
    }

    @PostMapping("/institutions/edit")
    public String editInstitution(@ModelAttribute Institution institution) {
        institutionService.save(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/add")
    public String addInstitution(Model model) {
        Institution institution = new Institution();
        model.addAttribute("institution", institution);
        return "addInstution";
    }
}
