package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name="book")
@Table(name="book")
public class BookEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 4000, nullable = false)
    private String synopsys;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuthorEntity author;

    @OneToMany(targetEntity = BookCategoryEntity.class, fetch = FetchType.LAZY)
    private List<BookCategoryEntity> categories;

    @OneToMany(targetEntity = EditionEntity.class, fetch = FetchType.LAZY)
    private List<EditionEntity> editions;


}
