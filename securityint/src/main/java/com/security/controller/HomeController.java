package com.security.controller;


import com.security.entiy.User;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.ws.Action;

@Controller
public class HomeController {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/adm")
    public String adminView() {
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdminView() {
        return "sadmin/sad";
    }

    @GetMapping(value = "/se")
    public String secureView(Model model) {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName",auth.getName());
        User user = repo.findByUserName(auth.getName());
        model.addAttribute("name",user.getUserName());

        return "secure/sec";
    }

    @GetMapping(value = "/u")
    public String userView() {
        return "user/u";
    }
}
