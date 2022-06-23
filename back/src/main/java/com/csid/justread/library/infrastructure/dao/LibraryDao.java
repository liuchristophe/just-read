package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryDao extends JpaRepository<LibraryEntity,UUID> {

}
