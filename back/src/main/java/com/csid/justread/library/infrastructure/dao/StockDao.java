package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StockDao extends JpaRepository<StockEntity, UUID> {
}
