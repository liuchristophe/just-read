package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BookCategoryPK implements Serializable {

//    @Column(name = "idBook")
//    private long idBook;
//
//    @Column(name = "idCategory")
//    private long idCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false)
    private BookEntity book;
}
