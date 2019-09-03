package com.resident.controller.admincontroller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
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
    public String addRentView(Model model, @PathVariable("id") Long id) {
        Optional<Rent> rent = this.rentRepo.findById(id);
        model.addAttribute("rent", rent);
        model.addAttribute("rentCollection", new RentCollection());
        return "user/rent/rentcollection";

    }

    @PostMapping(value = "add/{id}")
    public String addRent(@Valid RentCollection rentCollection, Model model, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "user/rent/rentcollection";

        } else {
//            if (rentCollection != null) {
//               Optional<RentCollection> rentCollection1 = this.repo.findById(id);
            Optional<Rent> rent = this.rentRepo.findById(id);
            rentCollection.setTenant(rent.get().getTenant());
            rentCollection.setHouseOwner(rent.get().getHouseOwner());
            rentCollection.setBuilding(rent.get().getBuilding());
            rentCollection.setFlat(rent.get().getFlat());
            rentCollection.setRentAmount(rent.get().getRentAmount());
            rentCollection.setRentdate(rent.get().getRentdate());
            this.repo.save(rentCollection);
            model.addAttribute("rentCollection", new RentCollection());
            model.addAttribute("successMsg", "Rent save Successfully");
        }
//            }


        return "user/rent/rentcollection";
    }

    @GetMapping(value = "list/{id}")
    public String addRentCllectionListView(Model model,Flat flat) {

       model.addAttribute("list",this.repo.findAllByFlat(flat));

        return "user/rent/collectionlist";

    }
    @GetMapping(value = "payrent/{id}")
    public String addRentCllectionListViewTenant(Model model,Tenant tenant) {

        model.addAttribute("list",this.repo.findAllByTenant(tenant));

        return "user/rent/payrent";

    }

}
