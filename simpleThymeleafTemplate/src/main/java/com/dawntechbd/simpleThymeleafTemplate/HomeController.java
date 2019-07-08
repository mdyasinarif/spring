package com.dawntechbd.simpleThymeleafTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String displayIndex() {

        return "index";
    }

    @GetMapping(value = "/about")
    public String displayAbout() {

        return "about";
    }

    @GetMapping(value = "/team")
    public String displayTeam() {

        return "team";
    }
}
