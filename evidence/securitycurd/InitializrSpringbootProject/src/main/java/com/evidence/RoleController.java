/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evidence;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author J2EE-39
 */
@Controller
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role")
    public String displayRole(Model model){
        model.addAttribute("role", new Role());

        return "role";
    }

    @PostMapping(value = "/role")
    public String displayRole(@Valid Role role, BindingResult bindingResult, Model model){
        this.repo.save(role);
        model.addAttribute("sucMsg", "Success !");

        return "role";
    }
}
