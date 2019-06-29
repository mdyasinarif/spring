package com.yasin.devtoolActultor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {
    @Autowired
    private StudentRepositiry repositiry;

    @GetMapping(value = "/save")
    public void saveStudent(){
        Student student = new Student(UUID.randomUUID().toString());
        this.repositiry.save(student);
        System.out.println("Save SuccessFully");
    }
    @GetMapping(value = "/students")
    public List<Student> getStudentList(){
        List<Student> list = new ArrayList<>();
        list = this.repositiry.findAll();
        return list;

    }
}
