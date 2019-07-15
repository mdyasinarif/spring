package com.imamia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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

    @GetMapping(value = "/blog")
    public String displayblog() {
        return "/blog";
    }

    @GetMapping(value = "/blog-detail")
    public String blogdetail() {
        return "/detail";
    }



}
