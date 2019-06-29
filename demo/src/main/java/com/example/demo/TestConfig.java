package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentAnnotation student = context.getBean(StudentAnnotation.class);
        student.setName("Yasin Arif");
        System.out.println(student);


    }
}
