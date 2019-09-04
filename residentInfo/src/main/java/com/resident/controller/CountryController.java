package com.resident.controller;


import com.resident.entity.address.Country;
import com.resident.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/country/")
public class CountryController {
    @Autowired
    private CountryRepo repo;

    @GetMapping(value = "add")
    public String addCountryView(Country country){
        return "location/country/add";

    }

    @PostMapping(value = "add")
    public String addCountry(@Valid Country country, BindingResult result, Model model){
        if(result.hasErrors()){
            return "location/country/add";
        }else{
            if(country != null){
                Country country1=this.repo.findByName(country.getName());
                if(country1 != null ){
                    model.addAttribute("existMsg","CountryName is already exist");
                }else{
                    this.repo.save(country);
                    model.addAttribute("country",new Country());
                    model.addAttribute("successMsg","Country save Successfully");
                }           }
        }
        return "location/country/add";
    }

    @GetMapping(value = "list")
    public String countryList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "location/country/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editCountryView(@PathVariable("id") Long id, Model model){
        model.addAttribute("country", this.repo.getOne(id));
        return "location/country/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editCountry(@Valid Country country, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "location/country/edit";
        }else{
            if(country != null){
                Country country1=this.repo.findByName(country.getName());
                if(country1 != null ){
                    model.addAttribute("existMsg","CountryName is already exist");
                    return "location/country/edit";
                }else{
                    this.repo.save(country);
                    model.addAttribute("country",new Country());
                    model.addAttribute("successMsg","CountryName save Success");
                }           }
        }
        return "redirect:/country/list";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delCountry(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/country/list";

    }
}
