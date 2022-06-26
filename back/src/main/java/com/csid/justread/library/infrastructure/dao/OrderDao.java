package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, UUID> {

    public List<OrderEntity> getAllOrderByLibraryId(UUID id);
}
