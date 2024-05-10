package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.VehiculeExceptions;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import com.example.gestiontrip.repository.VehiculeRepository;
import com.example.gestiontrip.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final TrajetProgrammerServiceImpl trajetProgrammerServiceImpl;

    @Autowired

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, TrajetProgrammerServiceImpl trajetProgrammerServiceImpl) {
        this.vehiculeRepository = vehiculeRepository;
        this.trajetProgrammerServiceImpl = trajetProgrammerServiceImpl;
    }


    @Override
    public List<Vehicule> getAllVehicules() {
        Iterable<Vehicule> vehiculesIterable = vehiculeRepository.findAll();
        List<Vehicule> vehiculesList = new ArrayList<>();
        vehiculesIterable.forEach(vehiculesList::add);
        if (vehiculesList.isEmpty()) {
            throw new VehiculeExceptions("No Vehicules found");
        }
        return vehiculesList;
    }
    @Override
    public Vehicule getVehiculeById(Long id){
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            return optionalVehicule.get();
        } else {
            throw new VehiculeExceptions("Vehicule not found with ID=" + id);
        }
    }
    @Override
    public Vehicule createVehicule(Vehicule vehicule) {
            return vehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        if (vehiculeRepository.existsById(id)) {
            vehicule.setIdVehicule(id);
            return vehiculeRepository.save(vehicule);
        } else
            throw new VehiculeExceptions("Unable to update. Vehicule not found with ID=" + id);
    }
    @Override
    public Vehicule deleteVehicule(Long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            Vehicule deletedVehicule = optionalVehicule.get();
            vehiculeRepository.deleteById(id);
            return deletedVehicule;
        } else {
            throw new VehiculeExceptions("Unable to delete. Vehicule not found with ID=" + id);
        }
    }
    @Override
    public boolean isVehiculeTimeDisponible(Long vehiculeId, LocalDate firstdate, LocalDate lastdate){
        List<TrajetProgrammer> trajets = trajetProgrammerServiceImpl.getAllTrajetProgrammers();
        for (TrajetProgrammer trajet : trajets) {
            if ((Objects.equals(trajet.getIdVehicule(), vehiculeId))) {
                if (trajet.getDateDepart().isBefore(lastdate) && trajet.getDateArriveePrevue().isAfter(firstdate)){
                    return  false;
                }
            }
        }
        return true;
    }


}