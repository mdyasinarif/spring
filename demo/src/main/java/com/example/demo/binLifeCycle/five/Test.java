package com.example.demo.binLifeCycle.five;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("binLifeCycleFiveContext.xml");
        context.getBean("myAwareService",MyAwareService.class);
        context.close();
    }
}
