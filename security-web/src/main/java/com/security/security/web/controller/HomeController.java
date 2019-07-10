package com.security.security.web.controller;

import com.security.security.web.entity.Student;
import com.security.security.web.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class HomeController {
    @Autowired
    private StudentRepo repo;
 @GetMapping(value = "/home")
    public String displayHome(){
        return "home";
    }


    @GetMapping(value = "/")
    public String displayindex(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String displaylogin(){
        return "login";
    }

    @GetMapping(value = "/insert")
    public String displayinsert(Model model){
     model.addAttribute("student",new Student());
        return "insert";
    }

    @PostMapping(value = "/insert")
    public String insertData(Model model,@Valid Student student){
     this.repo.save(student);
     return "insert";
    }

    @GetMapping(value = "/userlist")
    public String displayuserlist(Model model){
     model.addAttribute("list",this.repo.findAll());
     return "userlist";
    }

    @GetMapping(value = "/createuser")
    public String displayucreateuser(){
        return "createuser";
    }

}
