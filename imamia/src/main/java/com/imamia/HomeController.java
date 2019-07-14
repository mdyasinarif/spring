package com.imamia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayIndex() {
        return "/user/index";
    }

    @GetMapping(value = "/home")
    public String displayhome() {
        return "/user/index";
    }

    @GetMapping(value = "/about")
    public String displayabout() {
        return "/user/about";
    }

    @GetMapping(value = "/blog")
    public String displayblog() {
        return "/user/blog";
    }

    @GetMapping(value = "/blog-detail")
    public String displayblogdetail() {
        return "/user/blog-detail";
    }

    @GetMapping(value = "/contact")
    public String displaycontact() {
        return "/user/contact";
    }

    @GetMapping(value = "/gallery")
    public String displaygallery() {
        return "/user/gallery";
    }


    @GetMapping(value = "/menu")
    public String displaymenu() {
        return "/user/menu";
    }


    @GetMapping(value = "/reservation")
    public String displayreservation() {
        return "/user/reservation";
    }

    @GetMapping(value = "/login")
    public String displaylogin() {
        return "login";
    }


}
