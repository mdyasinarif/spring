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
import java.util.Optional;

@Controller
@RequestMapping(value = "/collection/")
public class RentCollectionController {

    @Autowired
    private RentCollectionRepo repo;
    @Autowired
    private BuildingRepo buildingRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private FlatRepo flatRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private RentRepo rentRepo;


    @GetMapping(value = "add/{id}")
    public String addRentView(Model model,@PathVariable("id") Long id) {
        Rent rent = this.rentRepo.getOne(id);
        model.addAttribute("rent", rent);
        model.addAttribute("rentCollection", new RentCollection());
        return "user/rent/rentcollection";

    }

    @PostMapping(value = "add/{id}")
    public String addRent(@Valid RentCollection rentCollection, Model model,BindingResult result,@PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "user/rent/rentcollection";

        } else {
            if (rentCollection != null) {
               Optional<RentCollection> rentCollection1 = this.repo.findById(id);
                if (rentCollection != null) {
                    model.addAttribute("existMsg", "BuildingName is already exist");
                } else {
                    this.repo.save(rentCollection);
                    model.addAttribute("rentCollection", new RentCollection());
                    model.addAttribute("successMsg", "Rent save Successfully");
                }
            }
        }

        return "user/rent/rentcollection";
    }

}
