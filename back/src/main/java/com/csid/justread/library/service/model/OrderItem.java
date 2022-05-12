package com.csid.justread.library.service.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class OrderItem {

    private UUID bookId;

    private UUID orderId;

    private int quantity;

    private float price;

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
