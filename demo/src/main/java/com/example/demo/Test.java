package com.example.demo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Resource resource = new ClassPathResource("ApplicationContext.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);

       Student student = (Student) context.getBean("studentBean");


        student.displayInfo();
    }
}
