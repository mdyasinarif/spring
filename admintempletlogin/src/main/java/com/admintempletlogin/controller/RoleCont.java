package com.admintempletlogin.controller;

import com.admintempletlogin.entity.Role;
import com.admintempletlogin.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleCont {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "add")
    public String displayRole(Model model){
        model.addAttribute("role" , new Role());
        return "admin/role";

    }
    @PostMapping(value = "add")
    public String addRole(@Valid Role role,Model model){
        if (role == null){
            model.addAttribute("errorMsg", "Something Wrong!");
        }else {
            this.repo.save(role);
            model.addAttribute("successMsg", "User Save Successfully");
        }
        return "admin/role";
    }
}
