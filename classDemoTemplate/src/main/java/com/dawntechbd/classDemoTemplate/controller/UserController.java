package com.dawntechbd.classDemoTemplate.controller;

import com.dawntechbd.classDemoTemplate.entity.Role;
import com.dawntechbd.classDemoTemplate.entity.User;
import com.dawntechbd.classDemoTemplate.repo.RoleRepo;
import com.dawntechbd.classDemoTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    @GetMapping(value = "/singUp")
    public String displayUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "userPage";
    }

    @PostMapping(value = "/singUp")
    public String singUp(@Valid User user, BindingResult result,
                         @RequestParam("photo") MultipartFile photo, Model model) throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("errMsg", "something wrong");
        }

        user.setPhotoPath("/upload/" + photo.getOriginalFilename());

//        for file upload
        byte[] bytes = photo.getBytes();
        Path path = Paths.get(UPLOAD_FOLDER + photo.getOriginalFilename());
        Files.write(path, bytes);
        //        for file upload end
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("successMsg", "Success");
        return "userPage";
    }
}
