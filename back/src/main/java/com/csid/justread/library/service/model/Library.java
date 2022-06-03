package com.csid.justread.library.service.model;

import com.csid.justread.address.service.model.Address;
import com.csid.justread.library.infrastructure.entity.OrderEntity;
import com.csid.justread.library.infrastructure.entity.StockItemEntity;

import java.util.List;
import java.util.UUID;

public class Library {

    private UUID id;

    private String name;

    private String urlImage;

    private Address address;

    private List<Order> orders;

    private List<StockItemEntity> stocks;

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

    public List<StockItemEntity> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockItemEntity> stocks) {
        this.stocks = stocks;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
