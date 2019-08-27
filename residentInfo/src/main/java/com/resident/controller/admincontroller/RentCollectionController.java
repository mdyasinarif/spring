package com.resident.controller.admincontroller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Rent;
import com.resident.entity.buliding.RentCollection;
import com.resident.entity.user.Police;
import com.resident.entity.user.Tenant;
import com.resident.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/collection/")
public class RentCollectionController {

    @Autowired
    private RentCollectionRepo repo;


    @Autowired
    private RentRepo rentRepo;
    @Autowired
    private BuildingRepo buildingRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private FlatRepo flatRepo;
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PoliceRepo policeRepo;


    @GetMapping(value = "add")
    public String addRentView(Rent rent, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable<Building> blist = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            blist = this.buildingRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }
        model.addAttribute("buildinglist", blist);
        model.addAttribute("flatlist", this.flatRepo.findAll());

        return "user/rent/rentcollection";

    }

    @PostMapping(value = "add")
    public String addRent(@Valid RentCollection rentCollection, BindingResult result, Model model, @RequestParam("id") Long id) {

                this.repo.save(rentCollection);
                model.addAttribute("rentCollection", new RentCollection());
                model.addAttribute("successMsg", "Rent save Successfully");


        return "user/rent/rentcollection";
    }



}
