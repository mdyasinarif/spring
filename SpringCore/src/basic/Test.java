/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("basic/AppcicationContex.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.setMsg("Hello Spring");
        System.out.println(hello.getMsg());
        
        Hello hello2 = (Hello) context.getBean("hello");
        System.out.println(hello2.getMsg());
        
    }
}
