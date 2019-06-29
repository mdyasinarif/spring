package com.example.demo.diSetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
        Employee employee = (Employee) context.getBean("e");
        employee.show();
    }
}
