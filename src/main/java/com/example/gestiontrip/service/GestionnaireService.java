package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Gestionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestionnaireService {
    List<Gestionnaire> getAllGestionnaires();
    Gestionnaire getGestionnaireById(Long id);
    Gestionnaire createGestionnaire(Gestionnaire gestionnaire);
    Gestionnaire updateGestionnaire(Long id, Gestionnaire gestionnaire);
    void deleteGestionnaire(Long id);
}