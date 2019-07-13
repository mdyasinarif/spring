package com.admintempletlogin.controller;


import com.admintempletlogin.entity.User;
import com.admintempletlogin.repo.RoleRepo;
import com.admintempletlogin.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class UserCont {
    @Autowired
    private UserRepo repo;


    @Autowired
    private RoleRepo roleRepo;



    @GetMapping(value = "add")
    public String displayUser(Model model){
        model.addAttribute("user" , new User());
        model.addAttribute("rolelist", roleRepo.findAll());
        return "admin/user";

    }
    @PostMapping(value = "add")
    public String addUser(@Valid User user,Model model){
        if (user == null){
            model.addAttribute("errorMsg", "Something Wrong!");
            model.addAttribute("rolelist", roleRepo.findAll());
        }else {
            this.repo.save(user);
            model.addAttribute("successMsg", "User Save Successfully");
            model.addAttribute("rolelist", roleRepo.findAll());
        }
        return "admin/user";
    }
}
