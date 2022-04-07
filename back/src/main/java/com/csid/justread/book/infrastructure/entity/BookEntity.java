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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<EditionEntity> editions;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public List<EditionEntity> getEditions() {
        return editions;
    }

    public void setEditions(List<EditionEntity> editions) {
        this.editions = editions;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
