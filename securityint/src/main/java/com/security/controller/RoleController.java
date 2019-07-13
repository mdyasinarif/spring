package com.security.controller;


import com.security.entiy.Permission;
import com.security.entiy.Role;
import com.security.entiy.User;
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
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleRepo repo;
    @Autowired
    private PermissionRepo permissionRepo;

    @GetMapping(value = "add")
    public String saveRole(Model model){
        model.addAttribute("role", new Role());
        model.addAttribute("permissionlist", permissionRepo.findAll());
       return "admin/role";
    }
    @PostMapping(value = "add")
    public String add(Model model, @Valid Role role) {
        if (role == null) {

            model.addAttribute("errorMsg", "Something Wrong!");
            model.addAttribute("permissionlist", permissionRepo.findAll());
        } else {
            this.repo.save(role);
            model.addAttribute("successMsg", "User Save Successfully");
            model.addAttribute("permissionlist", permissionRepo.findAll());

        }
        return "admin/role";
    }
//    @GetMapping(value = "permissionlist")
//    public String getList(Model model) {
//        List<Permission> list = this.permissionRepo.findAll();
//        model.addAttribute("permissionlist", list);
//        return "model";
//    }

//    @GetMapping(value = "rolelist")
//    public String getList(Model model) {
//        List<Role> list = this.repo.findAll();
//        model.addAttribute("rolelist", list);
//        return "role";
//    }
}
