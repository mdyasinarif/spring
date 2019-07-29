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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author J2EE-39
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    RoleRepo roleRepo;
    
    @GetMapping(value = "add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());

        return "users/add";
    }
    
     @PostMapping(value = "add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        this.repo.save(user);
        model.addAttribute("sucMsg", "Success !");

        return "users/add";
    }
    @GetMapping(value = "list")
    public String displayUser(Model model) {
        model.addAttribute("list", this.repo.findAll());

        return "users/list";
    }
    @GetMapping(value = "edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
    model.addAttribute("user",this.repo.getOne(id));
    return "users/edit";
    
    }
    @PostMapping(value = "edit/{id}")
    public String editUser(Model model, @Valid User user, @PathVariable Long id) {
    user.setId(id);
        if (user == null) {
            model.addAttribute("errorMsg","Something Worng");
        } else {
           this.repo.save(user);
        }
         return "redirect:/user/list";
    }
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id){
    this.repo.deleteById(id);
    return "redirect:/user/list";
    }
}
