package com.security.controller;


import com.security.entiy.Role;
import com.security.entiy.User;
import com.security.repo.RoleRepo;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepo repo;

@Autowired
private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

@Autowired
private PasswordEncoder encoder;

    @GetMapping(value = "add")
    public String saveRole(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepo.findAll());
        return "admin/user";
    }
    @PostMapping(value = "add")
    public String add(Model model, @Valid User user) {
        if (user == null) {
            model.addAttribute("errorMsg", "Something Wrong!");
            model.addAttribute("roles", roleRepo.findAll());
            return "admin/user";
        } else {
            user.setActive(true);
            user.setPassword(encoder.encode(user.getPassword()));
            this.repo.save(user);
            model.addAttribute("successMsg", "User Save Successfully");
            model.addAttribute("roles", roleRepo.findAll());

        }
        return "admin/user";
    }
//    @GetMapping(value = "userlist")
//    public String getList(Model model) {
//        List<User> list = this.repo.findAll();
//        model.addAttribute("userlist", list);
//        return "user";
//    }
}
