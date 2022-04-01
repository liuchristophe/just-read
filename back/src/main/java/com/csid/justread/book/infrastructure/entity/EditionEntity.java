package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;

@Entity(name="edition")
@Table(name="edition")
public class EditionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 200, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity book;

    @ManyToOne(fetch = FetchType.LAZY)
    private PublisherEntity publisher;



}
