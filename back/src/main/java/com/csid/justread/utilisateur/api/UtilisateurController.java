package com.csid.justread.utilisateur.api;

import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.service.model.Library;
import com.csid.justread.utilisateur.api.dto.UtilisateurDto;
import com.csid.justread.utilisateur.service.UtilisateurService;
import com.csid.justread.utilisateur.service.model.Utilisateur;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping()
    public UtilisateurDto createUtilisateur(@RequestBody UtilisateurDto utilisateurDto, @RequestParam String password){
        return new Converter().map(
                utilisateurService.create(
                        new Converter().map(utilisateurDto, Utilisateur.class), password
                ), UtilisateurDto.class);
    }

}
