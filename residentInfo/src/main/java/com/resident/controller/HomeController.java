package com.resident.controller;


import com.resident.entity.user.Employee;
import com.resident.entity.user.FamilyMamber;
import com.resident.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class HomeController {


    @Autowired
    private HouseOwnerRepo houseOwnerRepo;

    @Autowired
    private UserRepo repo;
    @Autowired
    private FamilyMamberRepo familyMamberRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BuillidingRepo buillidingRepo;

    @GetMapping(value = "/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {

            model.addAttribute("userdetail", this.houseOwnerRepo.findByUser(this.repo.findByUserName(auth.getName())));

            List<FamilyMamber> familyMamberList = this.familyMamberRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.repo.findByUserName(auth.getName())));
            model.addAttribute("family", familyMamberList);

            List<Employee> employeeList = this.employeeRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.repo.findByUserName(auth.getName())));
            model.addAttribute("employess", employeeList);

            model.addAttribute("building", this.buillidingRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.repo.findByUserName(auth.getName()))));


        }
        return "profile";
    }


    @GetMapping(value = "/editable")
    public String displayeditabletable() {
        return "editable-table";
    }

    @GetMapping(value = "/addrow")
    public String addrow() {
        return "addrow";
    }
    @GetMapping(value = "/owner")
    public String addrviewow() {

        return "user/houseOwner";
    }


}
//insert into role(role_name) values ("POLICE");
//insert into role(role_name) values ("HOUSEOWNER");
//insert into role(role_name) values ("TENANT");