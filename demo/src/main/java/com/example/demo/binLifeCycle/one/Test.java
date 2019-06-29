package com.example.demo.binLifeCycle.one;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("binLifeCycleOneContext.xml");
        Employee employee = (Employee) context.getBean("employeeBean");
        System.out.println(employee.toString());
        context.close();
    }
}
