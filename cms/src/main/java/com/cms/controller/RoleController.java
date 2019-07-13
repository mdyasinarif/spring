package com.cms.controller;


import com.cms.entity.Role;
import com.cms.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role")
    public String displayinsert(Model model) {
        model.addAttribute("role", new Role());
        return "admin/rolePage";
    }

    @PostMapping(value = "/role")
    public String insertData(Model model, @Valid Role role) {
        this.repo.save(role);
        return "admin/rolePage";
    }


}
