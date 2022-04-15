package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.OrderItemEntity;
import com.csid.justread.library.infrastructure.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItemEntity, OrderItemId> {
}
