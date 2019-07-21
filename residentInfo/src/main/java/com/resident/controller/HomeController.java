package com.resident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping(value = "/sign-in")
    public String displaySignin() {
        return "sign-in";
    }
    @GetMapping(value = "/sign-up")
    public String displaySignup() {
        return "sign-up";
    }
    @GetMapping(value = "/poilce")
    public String displayPolice() {
        return "poilce";
    }

}
