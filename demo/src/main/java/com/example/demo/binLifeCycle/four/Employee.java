package com.example.demo.binLifeCycle.four;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee  {
    private Long id;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';


    }
@PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("InIt Two method after proparty are set : " + id + " " + position);
    }
@PreDestroy
    public void destroy() throws Exception {
        System.out.println("Spring cleanUp Two! Employee is clean up");
    }
}

