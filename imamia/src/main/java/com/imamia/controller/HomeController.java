package com.imamia.controller;

import com.imamia.entity.News;
import com.imamia.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired
private NewsRepo newsRepo;

    @GetMapping(value = "/news/view")
    public String displayNews(News news, Model model){
        model.addAttribute("newsList",this.newsRepo.findAll());
        return "user/newsview";

    }
    @GetMapping(value = "/")
    public String displayIndex() {
        return "/index";
    }

    @GetMapping(value = "/home")
    public String displayhome() {
        return "/index";
    }

    @GetMapping(value = "/about")
    public String displayabout() {
        return "/about";
    }


    @GetMapping(value = "/contact")
    public String displaycontact() {
        return "/contact";
    }

    @GetMapping(value = "/gallery")
    public String displaygallery() {
        return "/gallery";
    }


    @GetMapping(value = "/menu")
    public String displaymenu() {
        return "/menu";
    }


    @GetMapping(value = "/reservation")
    public String displayreservation() {
        return "/reservation";
    }



    @GetMapping(value = "/blog-detail")
    public String blogdetail() {
        return "/detail";
    }



}
