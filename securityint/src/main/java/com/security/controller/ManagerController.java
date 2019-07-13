package com.security.controller;


import com.security.entiy.User;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/audio")
    public String audioView() {
        return "manager/audio";
    }

    @GetMapping(value = "/image")
    public String imageView() {
        return "manager/image";
    }

    @GetMapping(value = "/pdf")
    public String pdfView() {
        return "manager/pdf";
    }

    @GetMapping(value = "/video")
    public String videoView() {
        return "manager/video";
    }


}
