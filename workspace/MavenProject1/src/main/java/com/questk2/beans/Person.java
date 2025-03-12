package com.questk2.beans;

public class Person {
    private String name;
    private int age;
    private Address address;
    //Constructor injection
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address.getFullAddress());
    }
}

