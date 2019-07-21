package com.resident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

    @GetMapping(value = "/role")
    public String displayRole() {
        return "/admin/role";
    }

    @GetMapping(value = "/user")
    public String displayUser() {
        return "/admin/user";
    }




}
