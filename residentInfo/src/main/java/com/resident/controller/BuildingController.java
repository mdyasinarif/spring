package com.resident.controller;


import com.resident.entity.admin.Role;
import com.resident.entity.buliding.Building;
import com.resident.repo.BuildingRepo;
import com.resident.repo.HouseOwnerRepo;
import com.resident.repo.ThanaRepo;
import com.resident.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/building/")
public class BuildingController {
    @Autowired
    private BuildingRepo repo;
    @Autowired
    private ThanaRepo thanaRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "add")
    public String addBuildingView(Building building, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("ownerlist",this.houseOwnerRepo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
        model.addAttribute("thanalist", this.thanaRepo.findAll());
        return "user/building/add";

    }

    @PostMapping(value = "add")
    public String addBuilding(@Valid Building building, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/building/add";

        } else {
            if (building != null) {
                Building building1 = this.repo.findByName(building.getName());
                if (building1 != null) {
                    model.addAttribute("existMsg", "BuildingName is already exist");
                } else {
                    this.repo.save(building);
                    model.addAttribute("building", new Building());
                    model.addAttribute("successMsg", "Building save Successfully");
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    model.addAttribute("ownerlist",this.houseOwnerRepo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
                    model.addAttribute("thanalist", this.thanaRepo.findAll());
                }
            }
        }
        return "user/building/add";
    }

    @GetMapping(value = "list")
    public String buildingList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable <Building> list = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            list = this.repo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }

        model.addAttribute("list", list);

        return "user/building/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editBuildingView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("building", this.repo.getOne(id));
        return "user/building/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editBuilding(@Valid Building building, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/building/edit";
        } else {
            if (building != null) {
                Building building1 = this.repo.findByName(building.getName());
                if (building1 != null) {
                    model.addAttribute("existMsg", "BuildingName is already exist");
                    return "user/building/edit";
                } else {
                    this.repo.save(building);
                    model.addAttribute("building", new Building());
                    model.addAttribute("successMsg", "BuildingName save Success");
                }
            }
        }
        return "redirect:/user/building/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delBuilding(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/building/list";

    }
}
