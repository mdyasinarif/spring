package com.springHibernet.springHibernet.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String gender;
    private int age;
    @ManyToOne
    @JoinColumn(name = "dep_id",nullable = false)
    private Department department;

//    @ManyToOne
//    @JoinColumn(name = "c_id",nullable = false)
//    private Contract contract;


    public Student() {
    }

//    public Student(String name, String email, Department department) {
//        this.name = name;
//        this.email = email;
//        this.department = department;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
