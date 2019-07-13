package com.security.controller;

import com.security.entiy.Permission;
import com.security.entiy.Role;
import com.security.repo.PermissionRepo;
import com.security.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = "/permission/")
public class PermissionController {
    @Autowired
    private PermissionRepo repo;

    @GetMapping(value = "add")
    public String saveRole(Model model){
        model.addAttribute("permission", new Permission() {
        });
        return "admin/permission";
    }
    @PostMapping(value = "add")
    public String add(@Valid Permission permission,Model model) {
        if (permission == null) {
            model.addAttribute("errorMsg", "Something Wrong!");
            return "admin/permission";
        } else {
            this.repo.save(permission);
            model.addAttribute("successMsg", "User Save Successfully");

        }
        return "admin/permission";
    }

}
