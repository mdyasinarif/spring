package com.security.controller;


import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {


    @GetMapping(value = "/public")
    public String audioView() {
        return "public/publicView";
    }




}
