package com.resident.controller.addressController;


import com.resident.entity.address.CityCorporation;
import com.resident.entity.address.District;
import com.resident.entity.address.Thana;
import com.resident.repo.adddressRepo.CityCorporationRepo;
import com.resident.repo.adddressRepo.ThanaRepo;
import com.resident.repo.adddressRepo.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/location/thana/")
public class ThanaController {
    @Autowired
    private ThanaRepo repo;
    @Autowired
    private CityCorporationRepo cityCorporationRepo;

    @GetMapping(value = "add")
    public String addThanaView(Thana thana,Model model){
        model.addAttribute("cityCorporationlist", this.cityCorporationRepo.findAll());
        return "location/thana/add";

    }

    @PostMapping(value = "add")
    public String addThana(@Valid Thana thana, BindingResult result, Model model){
        if(result.hasErrors()){
            return "location/thana/add";
        }else{
            if(thana != null){
                Thana thana1=this.repo.findByName(thana.getName());
                if(thana1 != null ){
                    model.addAttribute("existMsg","ThanaName is already exist");
                }else{
                    this.repo.save(thana);
                    model.addAttribute("thana",new Thana());
                    model.addAttribute("successMsg","Thana save Successfully");
                }           }
        }
        return "location/thana/add";
    }

    @GetMapping(value = "list")
    public String thanaList(Model model){
        model.addAttribute("list", this.repo.findAll());

        return "location/thana/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editThanaView(@PathVariable("id") Long id, Model model){
        model.addAttribute("thana", this.repo.getOne(id));
        return "location/thana/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editThana(@Valid Thana thana, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "location/thana/edit";
        }else{
            if(thana != null){
                Thana thana1=this.repo.findByName(thana.getName());
                if(thana1 != null ){
                    model.addAttribute("existMsg","ThanaName is already exist");
                    return "location/thana/edit";
                }else{
                    this.repo.save(thana);
                    model.addAttribute("thana",new Thana());
                    model.addAttribute("successMsg","ThanaName save Success");
                }           }
        }
        return "redirect:/location/thana/list";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delThana(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/location/thana/list";

    }
}
