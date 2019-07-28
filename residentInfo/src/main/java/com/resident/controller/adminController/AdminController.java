package com.resident.controller.adminController;

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

@GetMapping(value = "/ediatable")
    public String displaytable() {
        return "editable-table";
    }




}
