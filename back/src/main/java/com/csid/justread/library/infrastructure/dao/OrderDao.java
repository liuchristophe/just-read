package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDao extends JpaRepository<OrderEntity, UUID> {
}
