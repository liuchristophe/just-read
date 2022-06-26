package com.csid.justread.library.api.dto;

import com.csid.justread.library.service.model.OrderItem;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderDto {

    private UUID id;

    private Date date;

    private Integer tva;

    private String utilisateur; //A changer par la suite en véritable user

    private List<OrderItemDto> orderItem;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<OrderItemDto> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItemDto> orderItem) {
        this.orderItem = orderItem;
    }
}
