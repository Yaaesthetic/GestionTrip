package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.ConducteurRepository;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import com.example.gestiontrip.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiponibleService {
    private final TrajetProgrammerRepository trajetProgrammerRepository;
    private final ConducteurRepository conducteurRepository;
    private final VehiculeRepository vehiculeRepository;

    @Autowired
    public DiponibleService(TrajetProgrammerRepository trajetProgrammerRepository, ConducteurRepository conducteurRepository, VehiculeRepository vehiculeRepository) {
        this.trajetProgrammerRepository = trajetProgrammerRepository;
        this.conducteurRepository = conducteurRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    public boolean DisponibleVehicule(Long vehiculeId){
        //boolean ruleVehicule=false;
        Optional<Vehicule> vehi = vehiculeRepository.findById(vehiculeId);
        if(vehi.isPresent()) {
            Vehicule vehicule = vehi.get();
            return vehicule.isDisponibilite();
        }
    return false;
    }
    public boolean DisponibleConducteur(Long conducteurId){
        //boolean ruleVehicule=false;
        Optional<Conducteur> vehi = conducteurRepository.findById(conducteurId);
        if(vehi.isPresent()) {
            Conducteur conducteur= vehi.get();
            return conducteur.isDisponibilite();
        }
        return false;
    }
    public boolean DisponibleTrajetPlanifier(Long trajetProgrammerId){
        boolean rule1= false;
        boolean rule2= false;
        Optional<TrajetProgrammer> trajet = trajetProgrammerRepository.findById(trajetProgrammerId);
        if(trajet.isPresent()) {
            TrajetProgrammer trajetProgrammer=trajet.get();
            if (trajetProgrammer.getDateArrivePrevue().compareTo(trajetProgrammer.getDateDepart()) > 0) {
                rule1 = true;
            }
            Optional<Vehicule> vehicule = vehiculeRepository.findById(trajetProgrammer.getIdVehicule());
            if (vehicule.isPresent()){
                Vehicule vehicule1=vehicule.get();
                if (vehicule1.getNbPlace() > trajetProgrammer.getNbPassagers())
                    rule2=true;
            }
        }
    return rule1 && rule2;
    }
}
