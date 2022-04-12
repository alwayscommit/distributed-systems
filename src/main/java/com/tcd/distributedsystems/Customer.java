package com.tcd.distributedsystems;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    public Integer zone_id;
    public String firstName;
    public String lastName;

    public Customer() {
    }

    public Customer(Integer zone_id, String firstName, String lastName) {
        this.zone_id = zone_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, zone_id=%s, firstName='%s', lastName='%s']",
                id, zone_id, firstName, lastName);
    }

}