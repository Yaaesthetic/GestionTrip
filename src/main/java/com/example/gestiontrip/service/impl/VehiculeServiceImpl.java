package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.VehiculeNotFoundException;
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
    private final VehiculeRepository VehiculeRepository;
    @Autowired
    public VehiculeServiceImpl(VehiculeRepository VehiculeRepository) {
        this.VehiculeRepository = VehiculeRepository;
    }
    @Override
    public List<Vehicule> getAllVehicules() {
        Iterable<Vehicule> VehiculesIterable = VehiculeRepository.findAll();
        List<Vehicule> VehiculesList = new ArrayList<>();
        VehiculesIterable.forEach(VehiculesList::add);
        if (VehiculesList.isEmpty()) {
            throw new VehiculeNotFoundException("No Vehicules found");
        }
        return VehiculesList;
    }
    @Override
    public Vehicule getVehiculeById(Long id){
        Optional<Vehicule> optionalVehicule = VehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            return optionalVehicule.get();
        } else {
            throw new VehiculeNotFoundException("Vehicule not found with id: " + id);
        }
    }
    @Override
    public Vehicule createVehicule(Vehicule vehicule) {
        return VehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        if (VehiculeRepository.existsById(id)) {
            vehicule.setIdVehicule(id);
            return VehiculeRepository.save(vehicule);
        } else
            throw new VehiculeNotFoundException("Unable to update. Vehicule not found with id: " + id);
    }
    @Override
    public void deleteVehicule(Long id) {
        if (VehiculeRepository.existsById(id))
            VehiculeRepository.deleteById(id);
        else
            throw new VehiculeNotFoundException("Unable to delete. Vehicule not found with ID: " + id);

    }
}