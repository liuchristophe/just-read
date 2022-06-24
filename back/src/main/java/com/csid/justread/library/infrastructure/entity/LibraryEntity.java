package com.csid.justread.library.infrastructure.entity;

import com.csid.justread.address.infrastructure.entity.AddressEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name="library")
@Table(name="library")
public class LibraryEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column()
    private String urlImage;

    @Column(length = 2500)
    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "libraryId")
    private List<OrderEntity> orders;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "libraryId")
    private List<StockItemEntity> stocks;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
