package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;

@Entity(name="bookCategory")
@Table(name="book_category")
public class BookCategoryEntity {

    @EmbeddedId
    private BookCategoryPK id;


}
