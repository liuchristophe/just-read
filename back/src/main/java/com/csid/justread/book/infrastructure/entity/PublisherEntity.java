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


}
