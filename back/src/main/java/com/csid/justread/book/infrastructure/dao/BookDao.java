package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Long> {
//    @Query
//    List<BookDto> getAllBookByCategoryName(String categoryName);
}
