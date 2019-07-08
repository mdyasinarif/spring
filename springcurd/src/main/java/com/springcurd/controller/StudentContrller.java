package com.springcurd.controller;

import com.springcurd.entity.Student;
import com.springcurd.repo.StudentRepo;
import com.springcurd.util.ImageOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class StudentContrller {
    @Autowired
    private StudentRepo studentRepo;

    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;

    //    view add page
    @GetMapping(value = "/add")
    public String addView(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    //    save student
    @PostMapping(value = "/add")
    public String add(Model model, @Valid Student student, @RequestParam("file") MultipartFile file) throws IOException {
        if (student == null) {
            model.addAttribute("errorMsg", "SomeThing Wrong!!!");
        } else {
            student.setPhoto("/images/new-"+file.getOriginalFilename());
            //file upload
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            // file upload end
            this.studentRepo.save(student);
            imageOptimizer.optimizeImage(UPLOADED_FOLDER,file,0.8f,100,120);
            model.addAttribute("successMsg", "Student Save Successfully");
        }
        return "add";
    }

    //    show edit page
    @GetMapping(value = "/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        model.addAttribute("student", this.studentRepo.getOne(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(Model model, @Valid Student student, @PathVariable Long id) {
        student.setId(id);
        if (student == null) {
            model.addAttribute("errorMsg", "Something Wrong!!!");
        } else {
            this.studentRepo.save(student);
            model.addAttribute("successMsg", "Data Update Successfully");
        }
        return "redirect:/students";
    }

    //delete view
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.studentRepo.deleteById(id);
        return "redirect:/students";
    }

    //    show students list
    @GetMapping(value = "/students")
    public String getList(Model model) {
        List<Student> list = this.studentRepo.findAll();
        model.addAttribute("list", list);
        return "list";
    }
}
