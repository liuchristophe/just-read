package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;

@Entity(name="category")
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(length = 100, nullable = false)
    private String name;

}
