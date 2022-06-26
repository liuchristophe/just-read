package com.csid.justread.book.infrastructure.entity;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="category")
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    /** Update : ajout du nombre de livre ayant cette catégorie **/

    @Formula("(SELECT COUNT(*) FROM justread.book_category bc WHERE bc.category_id = id)")
    private Long bookCount;

    //region * Methods *

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }


    //endregion
}
