package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.ConducteurExceptions;
import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.repository.ConducteurRepository;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import com.example.gestiontrip.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConducteurServiceImpl implements ConducteurService {
    private final ConducteurRepository conducteurRepository;
    private final TrajetProgrammerServiceImpl trajetProgrammerServiceImpl;
    @Autowired
    public ConducteurServiceImpl(ConducteurRepository conducteurRepository, TrajetProgrammerServiceImpl trajetProgrammerServiceImpl) {
        this.conducteurRepository = conducteurRepository;
        this.trajetProgrammerServiceImpl = trajetProgrammerServiceImpl;
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
            throw new ConducteurExceptions("Conducteur not found with ID=" + id);
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
            throw new ConducteurExceptions("Unable to update. Conducteur not found with ID=" + id);
    }
    @Override
    public Conducteur deleteConducteur(Long id) {
        Optional<Conducteur> optionalConducteur = conducteurRepository.findById(id);
        if (optionalConducteur.isPresent()) {
            Conducteur deletedConducteur = optionalConducteur.get();
            conducteurRepository.deleteById(id);
            return deletedConducteur;
        } else {
            throw new ConducteurExceptions("Unable to delete. Conducteur not found with ID=" + id);
        }
    }
    @Override
    public boolean isConducteurTimeDisponible(Long conducteurTd, LocalDate firstdate, LocalDate lastdate){
        List<TrajetProgrammer> trajets = trajetProgrammerServiceImpl.getAllTrajetProgrammers();
        for (TrajetProgrammer trajet : trajets) {
            if ((Objects.equals(trajet.getIdConducteur(), conducteurTd))) {
                if (trajet.getDateDepart().isBefore(lastdate) && trajet.getDateArriveePrevue().isAfter(firstdate)){
                    return  false;
                }
            }
        }
        return true;
    }

}