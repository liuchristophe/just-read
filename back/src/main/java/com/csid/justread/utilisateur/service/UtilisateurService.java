package com.csid.justread.utilisateur.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import com.csid.justread.utilisateur.infrastructure.dao.UtilisateurDao;
import com.csid.justread.utilisateur.infrastructure.entity.UtilisateurEntity;
import com.csid.justread.utilisateur.service.model.Utilisateur;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UtilisateurService {

    private final UtilisateurDao utilisateurDao;

    public UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    public Utilisateur create(Utilisateur utilisateur, String password){
        utilisateur.setPassword(password);
        return new Converter().map(
                utilisateurDao.save(
                        new Converter().map(utilisateur, UtilisateurEntity.class)
                ), Utilisateur.class);
    }
}
