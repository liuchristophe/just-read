package com.csid.justread.library.infrastructure.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="orderItem")
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItemEntity {

    @Id
    private UUID bookId;
    @Id
    private UUID orderId;

    @Column
    private int quantity;

    @Column
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
