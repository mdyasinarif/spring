package com.resident.controller.admincontroller;



import com.resident.entity.user.FamilyMamber;

import com.resident.repo.FamilyMamberRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("list", this.repo.findAll());

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
