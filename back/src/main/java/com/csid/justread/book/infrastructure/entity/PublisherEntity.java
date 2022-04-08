package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;

@Entity(name="publisher")
@Table(name="publisher")
public class PublisherEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
