package com.resident.controller.addresscontroller;


import com.resident.entity.address.District;
import com.resident.repo.adddressrepo.DistrictRepo;
import com.resident.repo.adddressrepo.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/location/district/")
public class DistrictController {
    @Autowired
    private DistrictRepo repo;
    @Autowired
    private DivisionRepo divisionRepo;

    @GetMapping(value = "add")
    public String addDistrictView(District district,Model model){
        model.addAttribute("divisionlist", this.divisionRepo.findAll());
        return "location/district/add";

    }

    @PostMapping(value = "add")
    public String addDistrict(@Valid District district, BindingResult result, Model model){
        if(result.hasErrors()){
            return "location/district/add";
        }else{
            if(district != null){
                District district1=this.repo.findByName(district.getName());
                if(district1 != null ){
                    model.addAttribute("existMsg","DistrictName is already exist");
                }else{
                    this.repo.save(district);
                    model.addAttribute("district",new District());
                    model.addAttribute("successMsg","District save Successfully");
                }           }
        }
        return "location/district/add";
    }

    @GetMapping(value = "list")
    public String districtList(Model model){
        model.addAttribute("list", this.repo.findAll());

        return "location/district/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editDistrictView(@PathVariable("id") Long id, Model model){
        model.addAttribute("district", this.repo.getOne(id));
        return "location/district/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editDistrict(@Valid District district, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "location/district/edit";
        }else{
            if(district != null){
                District district1=this.repo.findByName(district.getName());
                if(district1 != null ){
                    model.addAttribute("existMsg","DistrictName is already exist");
                    return "location/district/edit";
                }else{
                    this.repo.save(district);
                    model.addAttribute("district",new District());
                    model.addAttribute("successMsg","DistrictName save Success");
                }           }
        }
        return "redirect:/location/district/list";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delDistrict(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/location/district/list";

    }
}
