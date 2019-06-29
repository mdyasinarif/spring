package com.example.demo.diSetter;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee() {

    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Address address) {
        this.address = address;
    }

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void show() {
        System.out.println(id + " " + name);
        System.out.println(address.toString());
    }

}
