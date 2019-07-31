package com.resident.controller;

import com.resident.entity.admin.User;
import com.resident.repo.adminrepo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private RoleRepo roleRepo;
    @GetMapping(value = "/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping(value = "/sign-in")
    public String displaySignin() {
        return "sign-in";
    }

    @PostMapping(value = "/sign-up")
    public String displaySignup(User user, Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "sign-up";
    }

    @GetMapping(value ="/sign-up")
    public String showForm(User user, Model model) {
        model.addAttribute("user", new User());

        return "sign-up";
    }


    @GetMapping(value = "/editable")
    public String displayeditabletable() {
        return "editable-table";
    }

    @GetMapping(value = "/addrow")
    public String addrow() {
        return "addrow";
    }


}
