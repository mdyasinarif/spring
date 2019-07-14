package com.imamia.controller;

import com.imamia.entity.News;
import com.imamia.entity.Ebook;
import com.imamia.repo.EbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ebook/")
public class EbookController {
    @Autowired
    private EbookRepo repo;

    @GetMapping(value = "add")
    public String addEbookView(Ebook ebook){
        return "admin/ebook";

    }

    @PostMapping(value = "add")
    public String addebook(@Valid Ebook ebook, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/ebook";
        }else{
            if(ebook != null){
                News ebook1=this.repo.findByTitle(ebook.getTitle());
                if(ebook1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(ebook);
                    model.addAttribute("ebook",new Ebook());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/ebook";
    }

    @GetMapping(value = "list")
    public String ebookList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/ebooklist";
    }

    @GetMapping(value = "edit/{id}")
    public String editebookView(@PathVariable("id") Long id, Model model){
        model.addAttribute("ebook", this.repo.getOne(id));
        return "admin/ebookedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editebook(@Valid Ebook ebook, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/ebookedit";
        }else{
            if(ebook != null){
                News ebook1=this.repo.findByTitle(ebook.getTitle());
                if(ebook1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(ebook);
                    model.addAttribute("ebook",new Ebook());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/ebook/ebooklist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delebook(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/ebook/ebooklist";

    }
}
