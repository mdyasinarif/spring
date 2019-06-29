package com.example.demo.binLifeCycle.three;

import javax.annotation.PreDestroy;

public class Employee {
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

    public void inIt() throws Exception{
        System.out.println("InIt method after proparty are set : "+id+" "+position);
    }
    public void cleanUp()throws  Exception{
        System.out.println("Spring cleanUp ! Employee is clean up");
    }
}

