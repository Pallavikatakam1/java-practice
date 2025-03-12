package com.questk2.beans;

public class Address {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getFullAddress() {
        return street + ", " + city + ", " + country;
    }
}

