package com.resident.controller.addresscontroller;


import com.resident.entity.address.CityCorporation;
import com.resident.repo.adddressrepo.CityCorporationRepo;
import com.resident.repo.adddressrepo.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/cityCorporation/")
public class CityCorporationController {

    @Autowired
    private CityCorporationRepo repo;

    @Autowired
    private DistrictRepo districtRepo;

    @GetMapping(value = "add")
    public String addCityCorporationView(CityCorporation cityCorporation, Model model){
        model.addAttribute("districtlist", this.districtRepo.findAll());
        return "location/cityCorporation/add";

    }

    @PostMapping(value = "add")
    public String addCityCorporation(@Valid CityCorporation cityCorporation, BindingResult result, Model model){
        if(result.hasErrors()){
            return "location/cityCorporation/add";
        }else{
            if(cityCorporation != null){
                CityCorporation cityCorporation1=this.repo.findByName(cityCorporation.getName());
                if(cityCorporation1 != null ){
                    model.addAttribute("existMsg","CityCorporationName is already exist");
                }else{
                    this.repo.save(cityCorporation);
                    model.addAttribute("cityCorporation",new CityCorporation());
                    model.addAttribute("successMsg","CityCorporation save Successfully");
                }           }
        }
        return "location/cityCorporation/add";
    }

    @GetMapping(value = "list")
    public String cityCorporationList(Model model){
        model.addAttribute("list", this.repo.findAll());

        return "location/cityCorporation/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editCityCorporationView(@PathVariable("id") Long id, Model model){
        model.addAttribute("cityCorporation", this.repo.getOne(id));
        model.addAttribute("districtlist", this.districtRepo.findAll());
        return "location/cityCorporation/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editCityCorporation(@Valid CityCorporation cityCorporation, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "location/cityCorporation/edit";
        }else{
            if(cityCorporation != null){
                CityCorporation cityCorporation1=this.repo.findByName(cityCorporation.getName());
                if(cityCorporation1 != null ){
                    model.addAttribute("existMsg","CityCorporationName is already exist");
                    return "location/cityCorporation/edit";
                }else{
                    this.repo.save(cityCorporation);
                    model.addAttribute("cityCorporation",new CityCorporation());
                    model.addAttribute("successMsg","CityCorporationName save Success");
                }           }
        }
        return "redirect:/cityCorporation/list";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delCityCorporation(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/cityCorporation/list";
    }

}
