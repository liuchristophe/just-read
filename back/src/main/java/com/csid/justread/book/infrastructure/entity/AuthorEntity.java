package com.csid.justread.book.infrastructure.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name="author")
@Table(name="author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String firstname;

    @Column(length = 100)
    private String lastname;

    @Column(length = 100)
    private String pseudo;

    @Column(nullable = true, length = 2000)
    private String urlWiki;


}
