package com.csid.justread.utilisateur.infrastructure.dao;

import com.csid.justread.utilisateur.infrastructure.entity.UtilisateurEntity;
import com.csid.justread.utilisateur.service.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtilisateurDao extends JpaRepository<UtilisateurEntity, UUID> {
}
