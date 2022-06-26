package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.infrastructure.entity.StockItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockItemDao extends JpaRepository<StockItemEntity, UUID> {

    //public List<StockItemEntity> getAllByLibrary(LibraryEntity library);
}
