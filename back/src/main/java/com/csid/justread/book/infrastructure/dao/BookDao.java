package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookDao extends JpaRepository<BookEntity, UUID> {

    List<BookEntity> getAllBookByCategoriesName(String categoryName);
    List<BookEntity> getAllBookByPublisherName(String publisherName);
    List<BookEntity> getAllBookByAuthorId(UUID authorID);

    @Query("select b from book b where lower(b.title) like ?1")
    List<BookEntity> findByTitle( String title );

}
