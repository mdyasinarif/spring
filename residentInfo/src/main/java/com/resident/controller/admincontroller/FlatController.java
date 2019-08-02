package com.resident.controller.admincontroller;


import com.resident.entity.buliding.Flat;
import com.resident.repo.builldingrepo.BuillidingRepo;
import com.resident.repo.builldingrepo.FlatRepo;
import com.resident.repo.userrepo.HouseOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/flat/")
public class FlatController {
    @Autowired
    private FlatRepo repo;
    @Autowired
    private BuillidingRepo buillidingRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;

    @GetMapping(value = "add")
    public String addFlatView(Flat flat, Model model) {
        model.addAttribute("buillidinglist", this.buillidingRepo.findAll());
        model.addAttribute("ownerlist", this.houseOwnerRepo.findAll());
        return "user/flat/add";

    }

    @PostMapping(value = "add")
    public String addFlat(@Valid Flat flat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/flat/add";
        } else {
            if (flat != null) {
                Flat flat1 = this.repo.findByName(flat.getName());
                if (flat1 != null) {
                    model.addAttribute("existMsg", "FlatName is already exist");
                } else {
                    this.repo.save(flat);
                    model.addAttribute("flat", new Flat());
                    model.addAttribute("successMsg", "Flat save Successfully");
                }
            }
        }
        return "user/flat/add";
    }

    @GetMapping(value = "list")
    public String flatList(Model model) {
        model.addAttribute("list", this.repo.findAll());

        return "user/flat/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editFlatView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("flat", this.repo.getOne(id));
        return "user/flat/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editFlat(@Valid Flat flat, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/flat/edit";
        } else {
            if (flat != null) {
                Flat flat1 = this.repo.findByName(flat.getName());
                if (flat1 != null) {
                    model.addAttribute("existMsg", "FlatName is already exist");
                    return "user/flat/edit";
                } else {
                    this.repo.save(flat);
                    model.addAttribute("flat", new Flat());
                    model.addAttribute("successMsg", "FlatName save Success");
                }
            }
        }
        return "redirect:/user/flat/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delFlat(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/flat/list";

    }
}
