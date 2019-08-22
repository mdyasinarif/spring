package com.resident.controller.admincontroller;


import com.resident.entity.buliding.Rent;
import com.resident.entity.user.Tenant;
import com.resident.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private BuillidingRepo buillidingRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private FlatRepo flatRepo;
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "add")
    public String addRentView(Rent rent, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("buillidinglist", this.houseOwnerRepo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
        model.addAttribute("flatlist", this.flatRepo.findAll());
        return "user/rent/add";

    }

    @PostMapping(value = "add")
    public String addRent(@Valid Rent rent, BindingResult result, Model model,@PathVariable("contractNo") String  contractNo) {
        if (result.hasErrors()) {
            return "user/rent/add";
        } else {
            if (rent != null) {
                Rent rent1 = this.repo.findByRentType(rent.getRentType());
                if (rent1 != null) {
                    model.addAttribute("existMsg", "RentName is already exist");
                } else {

                    Tenant tenant = tenantRepo.findByContractNo(contractNo);
                    rent.setTenant(tenant);
                    this.repo.save(rent);
                    model.addAttribute("rent", new Rent());
                    model.addAttribute("successMsg", "Rent save Successfully");
                }
            }
        }
        return "user/rent/add";
    }

    @GetMapping(value = "list")
    public String rentList(Model model) {
        model.addAttribute("list", this.repo.findAll());

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
}
