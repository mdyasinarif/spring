package com.springHibernet.springHibernet.Controller;

import com.springHibernet.springHibernet.entity.Department;
import com.springHibernet.springHibernet.entity.Student;
import com.springHibernet.springHibernet.repo.DepartmentRepo;
import com.springHibernet.springHibernet.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StuentController {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping(value = "/student")
    public String displaySudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list",  this.repo.findAll());
        model.addAttribute("deplist",  this.departmentRepo.findAll());
        return "student";
    }

    @PostMapping(value = "/student")
    public String save(Model model, @Valid Student student, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("errMsg","Something Wrong");
        }else {
            this.repo.save(student);
            model.addAttribute("successMsg","Data save Successfully");
            model.addAttribute("list",  this.repo.findAll());
            model.addAttribute("deplist",  this.departmentRepo.findAll());
        }
        return "student";
    }

}
