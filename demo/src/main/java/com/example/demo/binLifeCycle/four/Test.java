package com.example.demo.binLifeCycle.four;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("binLifeCycleFourContext.xml");
        Employee employee = (Employee) context.getBean("employeeBean");
        System.out.println(employee.toString());
        context.close();
    }
}
