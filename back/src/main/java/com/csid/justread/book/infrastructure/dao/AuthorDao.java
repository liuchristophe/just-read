package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByLastnameAndFirstnameAndPseudo(String lastname, String firstname, String pseudo);
}
