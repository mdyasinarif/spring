package com.resident.controller;

import com.resident.entity.address.CityCorporation;
import com.resident.entity.admin.User;
import com.resident.repo.adminrepo.RoleRepo;
import com.resident.repo.adminrepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepo repo;
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

    @GetMapping(value ="/sign-up")
    public String showForm(User user, Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "sign-up";
    }

    @PostMapping(value = "/sign-up")
    public String displaySignup(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "sign-up";
        }else{
            if(user != null){
                User user1=this.repo.findByUserName(user.getUserName());
                if(user1 != null ){
                    model.addAttribute("existMsg","User is already exist");
                }else{
                    this.repo.save(user);
                    model.addAttribute("user",new User());
                    model.addAttribute("successMsg","User save Successfully");
                }           }
        }
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
//insert into role(role_name) values ("POLICE");
//insert into role(role_name) values ("HOUSEOWNER");
//insert into role(role_name) values ("TENANT");