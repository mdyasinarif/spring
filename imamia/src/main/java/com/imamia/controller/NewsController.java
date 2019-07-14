package com.imamia.controller;

import com.imamia.entity.News;
import com.imamia.entity.Role;
import com.imamia.repo.NewsRepo;
import com.imamia.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/news/")
public class NewsController {
    @Autowired
    private NewsRepo repo;

    @GetMapping(value = "add")
    public String addNewsView(News news){
        return "admin/news";

    }

    @PostMapping(value = "add")
    public String addNews(@Valid News news, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/news";
        }else{
            if(news != null){
                News news1=this.repo.findByTitle(news.getTitle());
                if(news1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(news);
                    model.addAttribute("news",new News());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/news";
    }

    @GetMapping(value = "list")
    public String newsList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/newslist";
    }

    @GetMapping(value = "edit/{id}")
    public String editNewsView(@PathVariable("id") Long id, Model model){
        model.addAttribute("new", this.repo.getOne(id));
        return "admin/newsedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editNews(@Valid News news, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/newsedit";
        }else{
            if(news != null){
                News news1=this.repo.findByTitle(news.getTitle());
                if(news1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(news);
                    model.addAttribute("news",new News());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/news/newslist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delNews(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/news/newslist";

    }
}
