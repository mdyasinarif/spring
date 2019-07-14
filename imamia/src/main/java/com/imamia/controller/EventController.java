package com.imamia.controller;

import com.imamia.entity.Event;
import com.imamia.entity.News;
import com.imamia.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/event/")
public class EventController {
    @Autowired
    private EventRepo repo;

    @GetMapping(value = "add")
    public String addeventView(Event event){
        return "admin/event";

    }

    @PostMapping(value = "add")
    public String addEvent(@Valid Event event, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/event";
        }else{
            if(event != null){
                News event1=this.repo.findByTitle(event.getTitle());
                if(event1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(event);
                    model.addAttribute("event",new Event());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/event";
    }

    @GetMapping(value = "list")
    public String eventList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/eventlist";
    }

    @GetMapping(value = "edit/{id}")
    public String editeventView(@PathVariable("id") Long id, Model model){
        model.addAttribute("event", this.repo.getOne(id));
        return "admin/eventedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editevent(@Valid Event event, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/eventedit";
        }else{
            if(event != null){
                News event1=this.repo.findByTitle(event.getTitle());
                if(event1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(event);
                    model.addAttribute("event",new Event());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/event/eventlist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delevent(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/event/eventlist";

    }
}
