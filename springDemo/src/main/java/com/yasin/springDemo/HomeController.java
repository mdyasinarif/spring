package com.yasin.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private StudentRepository repository;
    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("student",new Student());
        return "home";
    }
//    take input frome the browser
    @PostMapping(value = "/")
    public String saveStudent(Model model, @Valid Student student){
        this.repository.save(student);
        return "redirect:/students";
}
    @GetMapping(value = "/students")
    public String getStudentList(Model model){
        List<Student> studentList = this.repository.findAll();
        model.addAttribute("slist",studentList);
        return "list";
    }


    @GetMapping(value = "/students2")
    public ModelAndView displayStudent(){
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("studentList",this.repository.findAll());
       modelAndView.setViewName("list2");
       return modelAndView;
    }
    // show studentent by id method pathtVariable
    @GetMapping(value = "/students/{id}")
    public String getStudentById(Model model, @PathVariable("id") Long id){
        Student s = this.repository.getOne(id);
        model.addAttribute("stu",s);
        return "student";
    }

@GetMapping(value = "/s")
    public String studentById(Model model,@RequestParam(name = "id",required = false,defaultValue = "1") Long id){
     Optional<Student> s = this.repository.findById(id);
//      Student s = this.repository.getOne(id);
        model.addAttribute("stu",s);
        return "student2";
    }












    @GetMapping(value = "/about")
    public String aboutDisplay(Model model){
        model.addAttribute("Welcome","About");
        return "about";
    }
    @GetMapping(value = "/contract")
    public String contractDisplay(Model model){
        model.addAttribute("Welcome","Contract");
        return "contract";
    }
}
