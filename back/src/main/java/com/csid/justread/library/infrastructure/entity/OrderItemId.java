package com.csid.justread.library.infrastructure.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class OrderItemId implements Serializable {

    private UUID bookId;
    private UUID orderId;

    public OrderItemId() {
    }

    public OrderItemId(UUID bookId, UUID orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId accountId = (OrderItemId) o;
        return bookId.equals(accountId.bookId) &&
                orderId.equals(accountId.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, orderId);
    }
}
