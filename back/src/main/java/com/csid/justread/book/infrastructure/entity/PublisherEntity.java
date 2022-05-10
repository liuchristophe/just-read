package com.csid.justread.book.infrastructure.entity;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="publisher")
@Table(name="publisher")
public class PublisherEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    @Formula("(SELECT COUNT(*) FROM justread.book b WHERE b.publisher_id = id)")
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

    public PublisherEntity() {
    }
//endregion
}
