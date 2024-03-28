package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Conducteur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConducteurService  {
    public List<Conducteur> getAllConducteurs();
    Conducteur getConducteurById(Long id);
    Conducteur createConducteur(Conducteur conducteur);
    Conducteur updateConducteur(Long id, Conducteur conducteur);
    Conducteur deleteConducteur(Long id);
}