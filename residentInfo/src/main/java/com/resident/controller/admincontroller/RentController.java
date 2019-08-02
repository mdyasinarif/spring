package com.resident.controller.admincontroller;


import com.resident.entity.buliding.Rent;
import com.resident.repo.builldingrepo.BuillidingRepo;
import com.resident.repo.builldingrepo.FlatRepo;
import com.resident.repo.builldingrepo.RentRepo;
import com.resident.repo.userrepo.HouseOwnerRepo;
import com.resident.repo.userrepo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "add")
    public String addRentView(Rent rent, Model model) {
        model.addAttribute("buillidinglist", this.buillidingRepo.findAll());
        model.addAttribute("flatlist", this.flatRepo.findAll());
        model.addAttribute("ownerlist", this.houseOwnerRepo.findAll());
        model.addAttribute("tenantlist", this.tenantRepo.findAll());
        return "user/rent/add";

    }

    @PostMapping(value = "add")
    public String addRent(@Valid Rent rent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/rent/add";
        } else {
            if (rent != null) {
                Rent rent1 = this.repo.findByRentType(rent.getRentType());
                if (rent1 != null) {
                    model.addAttribute("existMsg", "RentName is already exist");
                } else {
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
