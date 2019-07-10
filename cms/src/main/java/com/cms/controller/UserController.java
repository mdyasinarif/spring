package com.cms.controller;


import com.cms.entity.User;
import com.cms.repo.RoleRepo;
import com.cms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user")
    public String displayinsert(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "admin/userPage";
    }

    @PostMapping(value = "/user")
    public String insertData(Model model, @Valid User user) {
        this.repo.save(user);
        return "admin/userPage";
    }
}
