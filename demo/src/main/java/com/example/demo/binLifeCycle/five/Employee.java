package com.example.demo.binLifeCycle.five;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee  {
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

