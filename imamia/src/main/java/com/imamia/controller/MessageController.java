package com.imamia.controller;

import com.imamia.entity.Massage;
import com.imamia.entity.News;
import com.imamia.repo.MassageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/massage/")
public class MessageController {
    @Autowired
    private MassageRepo repo;

    @GetMapping(value = "add")
    public String addmassageView(Massage massage){
        return "admin/massage";

    }

    @PostMapping(value = "add")
    public String addMassage(@Valid Massage massage, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/massage";
        }else{
            if(massage != null){
                News massage1=this.repo.findByTitle(massage.getTitle());
                if(massage1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(massage);
                    model.addAttribute("massage",new Massage());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/massage";
    }

    @GetMapping(value = "list")
    public String massageList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/massagelist";
    }

    @GetMapping(value = "edit/{id}")
    public String editmassageView(@PathVariable("id") Long id, Model model){
        model.addAttribute("massage", this.repo.getOne(id));
        return "admin/massageedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editmassage(@Valid Massage massage, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/massageedit";
        }else{
            if(massage != null){
                News massage1=this.repo.findByTitle(massage.getTitle());
                if(massage1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/massageedit";
                }else{
                    this.repo.save(massage);
                    model.addAttribute("massage",new Massage());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/massage/massagelist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delmassage(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/massage/massagelist";

    }
}
