package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.GestionnaireExceptions;
import com.example.gestiontrip.model.Gestionnaire;
import com.example.gestiontrip.repository.GestionnaireRepository;
import com.example.gestiontrip.service.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GestionnaireServiceImpl implements GestionnaireService {

    private final GestionnaireRepository gestionnaireRepository;

    @Autowired
    public GestionnaireServiceImpl(GestionnaireRepository gestionnaireRepository) {
        this.gestionnaireRepository = gestionnaireRepository;
    }

    @Override
    public List<Gestionnaire> getAllGestionnaires() {
        Iterable<Gestionnaire> gestionnairesIterable = gestionnaireRepository.findAll();
        List<Gestionnaire> gestionnairesList = new ArrayList<>();
        gestionnairesIterable.forEach(gestionnairesList::add);
        if (gestionnairesList.isEmpty()) {
            throw new GestionnaireExceptions("No gestionnaires found");
        }
        return gestionnairesList;
    }

    @Override
    public Gestionnaire getGestionnaireById(Long id) {
        Optional<Gestionnaire> optionalGestionnaire = gestionnaireRepository.findById(id);
        if (optionalGestionnaire.isPresent()) {
            return optionalGestionnaire.get();
        } else {
            throw new GestionnaireExceptions("Gestionnaire not found with ID=" + id);
        }
    }

    @Override
    public Gestionnaire createGestionnaire(Gestionnaire gestionnaire) {
        return gestionnaireRepository.save(gestionnaire);
    }

    @Override
    public Gestionnaire updateGestionnaire(Long id, Gestionnaire gestionnaire) {
        if (gestionnaireRepository.existsById(id)) {
            gestionnaire.setIdGestionnaire(id);
            return gestionnaireRepository.save(gestionnaire);
        } else {
            throw new GestionnaireExceptions("Unable to update. Gestionnaire not found with ID=" + id);
        }
    }

    @Override
    public void deleteGestionnaire(Long id) {
        Optional<Gestionnaire> optionalGestionnaire = gestionnaireRepository.findById(id);
        if (optionalGestionnaire.isPresent()) {
            gestionnaireRepository.deleteById(id);
        } else {
            throw new GestionnaireExceptions("Unable to delete. Gestionnaire not found with ID=" + id);
        }
    }
}
