package com.resident.controller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.user.FamilyMamber;

import com.resident.entity.user.HouseOwner;
import com.resident.repo.FamilyMamberRepo;
import com.resident.repo.HouseOwnerRepo;
import com.resident.repo.TenantRepo;
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
@RequestMapping(value = "/family/")
public class FamilymemberController {
    @Autowired
    private FamilyMamberRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private TenantRepo tenantRepo;

    @GetMapping(value = "add")
    public String addFamilyMamberView(FamilyMamber familyMamber, Model model) {

        return "user/family/add";

    }

    @PostMapping(value = "add")
    public String addFamilyMamber(@Valid FamilyMamber familyMamber, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/family/add";

        } else {
            if (familyMamber != null) {
                FamilyMamber familyMamber1 = this.repo.findByName(familyMamber.getName());
                if (familyMamber1 != null) {
                    model.addAttribute("existMsg", "FamilyMamberName is already exist");
                } else {
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

                    User user = this.userRepo.findByUserName(auth.getName());

                    String rolename = null;
                    for (Role r : user.getRoles()) {
                        rolename = r.getRoleName();
                    }
                    if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
                        familyMamber.setHouseOwner(this.houseOwnerRepo.findByUser(user));
                    } else if (rolename.equalsIgnoreCase("TENANT")) {
                        familyMamber.setTenant(this.tenantRepo.findByUser(user));
                    }


                    this.repo.save(familyMamber);
                    model.addAttribute("familyMamber", new FamilyMamber());
                    model.addAttribute("successMsg", "FamilyMamber save Successfully");
                }
            }
        }
        return "user/family/add";
    }

    @GetMapping(value = "list")
    public String familyList(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable<FamilyMamber> list = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            list = this.repo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        } else if (rolename.equalsIgnoreCase("TENANT")) {
            list = this.repo.findAllByTenant(this.tenantRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }


        model.addAttribute("list", list);

        return "user/family/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editFamilyMamberView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("familyMamber", this.repo.getOne(id));
        return "user/family/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editFamilyMamber(@Valid FamilyMamber familyMamber, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/family/edit";
        } else {
            if (familyMamber != null) {
                FamilyMamber family1 = this.repo.findByName(familyMamber.getName());
                if (family1 != null) {
                    model.addAttribute("existMsg", "FamilyMamberName is already exist");
                    return "user/family/edit";
                } else {
                    this.repo.save(familyMamber);
                    model.addAttribute("familyMamber", new FamilyMamber());
                    model.addAttribute("successMsg", "FamilyMamberName save Success");
                }
            }
        }
        return "redirect:/user/family/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delFamilyMamber(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/family/list";

    }
}
