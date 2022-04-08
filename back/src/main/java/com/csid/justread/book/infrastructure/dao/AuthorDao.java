package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity, UUID> {
    @Query()
    Optional<AuthorEntity> findAuthorByLastnameAndFirstnameAndPseudo(String lastname, String firstname, String pseudo);
}
