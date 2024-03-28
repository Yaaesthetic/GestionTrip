package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.VehiculeExceptions;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.VehiculeRepository;
import com.example.gestiontrip.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final DiponibleServiceImpl diponibleServiceImpl;

    @Autowired

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, DiponibleServiceImpl diponibleServiceImpl) {
        this.vehiculeRepository = vehiculeRepository;
        this.diponibleServiceImpl = diponibleServiceImpl;
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



}