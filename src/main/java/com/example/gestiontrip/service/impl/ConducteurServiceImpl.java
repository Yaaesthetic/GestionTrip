package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.ConducteurExceptions;
import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.repository.ConducteurRepository;
import com.example.gestiontrip.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConducteurServiceImpl implements ConducteurService {
    private final ConducteurRepository conducteurRepository;
    @Autowired
    public ConducteurServiceImpl(ConducteurRepository conducteurRepository) {
        this.conducteurRepository = conducteurRepository;
    }
    @Override
    public List<Conducteur> getAllConducteurs() {
        Iterable<Conducteur> conducteursIterable = conducteurRepository.findAll();
        List<Conducteur> conducteursList = new ArrayList<>();
        conducteursIterable.forEach(conducteursList::add);
        if (conducteursList.isEmpty()) {
            throw new ConducteurExceptions("No conducteurs found");
        }
        return conducteursList;
    }
    @Override
    public Conducteur getConducteurById(Long id){
        Optional<Conducteur> optionalConducteur = conducteurRepository.findById(id);
        if (optionalConducteur.isPresent()) {
            return optionalConducteur.get();
        } else {
            throw new ConducteurExceptions("Conducteur not found with id: " + id);
        }
    }
    @Override
    public Conducteur createConducteur(Conducteur conducteur) {
        return conducteurRepository.save(conducteur);
    }
    @Override
    public Conducteur updateConducteur(Long id, Conducteur conducteur) {
        if (conducteurRepository.existsById(id)) {
            conducteur.setIdConducteur(id);
            return conducteurRepository.save(conducteur);
        } else
            throw new ConducteurExceptions("Unable to update. Conducteur not found with id: " + id);
    }
    @Override
    public void deleteConducteur(Long id) {
        if (conducteurRepository.existsById(id))
            conducteurRepository.deleteById(id);
        else
            throw new ConducteurExceptions("Unable to delete. Conducteur not found with ID: " + id);
    }
}