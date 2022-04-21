package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.library.infrastructure.entity.OrderItemEntity;
import com.csid.justread.library.infrastructure.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItemEntity, OrderItemId> {

    BookEntity getBookByBookId(UUID id);
}
