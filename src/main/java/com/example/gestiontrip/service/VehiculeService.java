package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Vehicule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculeService {
    public List<Vehicule> getAllVehicules();
    Vehicule getVehiculeById(Long id);
    Vehicule createVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Long id, Vehicule vehicule);
    void deleteVehicule(Long id);
}
