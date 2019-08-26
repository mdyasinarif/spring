package com.resident.controller.admincontroller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Rent;
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
@RequestMapping(value = "/rent/")
public class RentController {
    @Autowired
    private RentRepo repo;
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
        return "user/rent/add";

    }

    @PostMapping(value = "add")
    public String addRent(@Valid Rent rent, BindingResult result, Model model, @RequestParam("contractNo") String contractNo) {

        if (result.hasErrors()) {
            return "user/rent/add";
        } else {
            if (rent != null) {
                Tenant tenant = tenantRepo.findByContractNo(contractNo);
                rent.setTenant(tenant);
                rent.setThana(rent.getBuilding().getThana());
                rent.getFlat().setStatus(false);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                rent.setHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
                this.repo.save(rent);
                model.addAttribute("rent", new Rent());
                model.addAttribute("successMsg", "Rent save Successfully");

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
            }

        }
        return "user/rent/add";
    }

    @GetMapping(value = "list")
    public String rentList(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Iterable<Rent> list = this.repo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        model.addAttribute("list", list);

        return "user/rent/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editRentView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("rent", this.repo.getOne(id));
        return "user/rent/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editRent(@Valid Rent rent, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/rent/edit";
        } else {
            if (rent != null) {
                Rent rent1 = this.repo.findByRentType(rent.getRentType());
                if (rent1 != null) {
                    model.addAttribute("existMsg", "RentName is already exist");
                    return "user/rent/edit";
                } else {
                    this.repo.save(rent);
                    model.addAttribute("rent", new Rent());
                    model.addAttribute("successMsg", "RentName save Success");
                }
            }
        }
        return "redirect:/user/rent/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRent(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/rent/list";

    }

    @GetMapping(value = "listforpolice")
    public String rentListForPolice(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUserName(auth.getName());
        Police police = this.policeRepo.findByUser(user);
        model.addAttribute("list", this.repo.findAllByThana(police.getThana()));

        return "user/police/rentlist";
    }
}
