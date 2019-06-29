package com.example.demo.diAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public Employee employeeBean(){
        Employee employee = new Employee(101,"Md Yasin",
                new Address("Dhaka","Dhaka","Bangladesh"));
        return employee;
    }

//    @Bean
//    public Address addressBean(){
//        Address address = new Address("Dhaka","Dhaka","Bangladesh");
//        return address;
//    }
}
