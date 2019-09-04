package com.resident.controller;


import com.resident.entity.address.Division;
import com.resident.repo.CountryRepo;
import com.resident.repo.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/division/")
public class DivisionController {
    @Autowired
    private DivisionRepo repo;
    @Autowired
    private CountryRepo countryRepo;

    @GetMapping(value = "add")
    public String addDivisionView(Division division,Model model){
        model.addAttribute("countrylist", this.countryRepo.findAll());
        return "location/division/add";

    }

    @PostMapping(value = "add")
    public String addDivision(@Valid Division division, BindingResult result, Model model){
        if(result.hasErrors()){
            return "location/division/add";
        }else{
            if(division != null){
                Division division1=this.repo.findByName(division.getName());
                if(division1 != null ){
                    model.addAttribute("existMsg","DivisionName is already exist");
                }else{
                    this.repo.save(division);
                    model.addAttribute("division",new Division());
                    model.addAttribute("successMsg","Division save Successfully");
                    model.addAttribute("countrylist", this.countryRepo.findAll());
                }           }
        }
        return "location/division/add";
    }

    @GetMapping(value = "list")
    public String divisionList(Model model){
        model.addAttribute("list", this.repo.findAll());

        return "location/division/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editDivisionView(@PathVariable("id") Long id, Model model){
        model.addAttribute("division", this.repo.getOne(id));
        return "location/division/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editDivision(@Valid Division division, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "location/division/edit";
        }else{
            if(division != null){
                Division division1=this.repo.findByName(division.getName());
                if(division1 != null ){
                    model.addAttribute("existMsg","DivisionName is already exist");
                    return "location/division/edit";
                }else{
                    this.repo.save(division);
                    model.addAttribute("division",new Division());
                    model.addAttribute("successMsg","DivisionName save Success");
                }           }
        }
        return "redirect:/division/list";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delDivision(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/division/list";

    }
}
