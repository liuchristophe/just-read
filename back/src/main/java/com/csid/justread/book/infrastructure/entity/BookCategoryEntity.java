package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;

@Entity(name="bookCategory")
@Table(name="book_category")
public class BookCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private BookEntity book;
}
