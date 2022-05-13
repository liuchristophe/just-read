package com.csid.justread.library.api.dto;

import com.csid.justread.address.api.dto.AddressDto;
import com.csid.justread.library.infrastructure.entity.StockItemEntity;


import java.util.List;
import java.util.UUID;

public class LibraryDto {

    private UUID id;

    private String name;

    private AddressDto address;

    private List<OrderDto> orders;

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<StockItemEntity> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockItemEntity> stocks) {
        this.stocks = stocks;
    }
}
