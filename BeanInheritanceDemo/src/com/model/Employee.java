package com.model;

public class Employee {

    private int id;
    private String name;
    private Address address;

    public Employee() {}

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /*public Employee(String id, String name, Address address) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.address = address;
    }*/

    public void show() {
        System.out.println(id + " " + name);
        System.out.println(address);
    }
}
