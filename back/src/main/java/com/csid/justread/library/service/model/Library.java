package com.csid.justread.library.service.model;

import com.csid.justread.address.service.model.Address;
import com.csid.justread.library.infrastructure.entity.OrderEntity;

import java.util.List;
import java.util.UUID;

public class Library {

    private UUID id;

    private String name;

    private Address address;

    private List<Order> orders;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
