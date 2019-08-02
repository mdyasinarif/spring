package com.resident.controller.admincontroller;


import com.resident.entity.buliding.Builliding;

import com.resident.repo.adddressrepo.ThanaRepo;
import com.resident.repo.builldingrepo.BuillidingRepo;
import com.resident.repo.userrepo.HouseOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/builliding/")
public class BuillidingController {
    @Autowired
    private BuillidingRepo repo;
    @Autowired
    private ThanaRepo thanaRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;

    @GetMapping(value = "add")
    public String addBuillidingView(Builliding builliding, Model model) {
        model.addAttribute("thanalist", this.thanaRepo.findAll());
        model.addAttribute("ownerlist", this.houseOwnerRepo.findAll());
        return "user/builliding/add";

    }

    @PostMapping(value = "add")
    public String addBuilliding(@Valid Builliding builliding, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/builliding/add";

        } else {
            if (builliding != null) {
                Builliding builliding1 = this.repo.findByName(builliding.getName());
                if (builliding1 != null) {
                    model.addAttribute("existMsg", "BuillidingName is already exist");
                } else {
                    this.repo.save(builliding);
                    model.addAttribute("builliding", new Builliding());
                    model.addAttribute("successMsg", "Builliding save Successfully");
                }
            }
        }
        return "user/builliding/add";
    }

    @GetMapping(value = "list")
    public String buillidingList(Model model) {
        model.addAttribute("list", this.repo.findAll());

        return "user/builliding/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editBuillidingView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("builliding", this.repo.getOne(id));
        return "user/builliding/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editBuilliding(@Valid Builliding builliding, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/builliding/edit";
        } else {
            if (builliding != null) {
                Builliding builliding1 = this.repo.findByName(builliding.getName());
                if (builliding1 != null) {
                    model.addAttribute("existMsg", "BuillidingName is already exist");
                    return "user/builliding/edit";
                } else {
                    this.repo.save(builliding);
                    model.addAttribute("builliding", new Builliding());
                    model.addAttribute("successMsg", "BuillidingName save Success");
                }
            }
        }
        return "redirect:/user/builliding/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delBuilliding(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/builliding/list";

    }
}
