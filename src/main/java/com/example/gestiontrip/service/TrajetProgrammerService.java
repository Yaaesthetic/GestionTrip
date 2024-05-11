package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrajetProgrammerService {
    public List<TrajetProgrammer> getAllTrajetProgrammers();
    TrajetProgrammer getTrajetProgrammerById(Long id);
    TrajetProgrammer createTrajetProgrammer(TrajetProgrammer trajetProgrammer);
    TrajetProgrammer updateTrajetProgrammer(Long id, TrajetProgrammer trajetProgrammer);
    TrajetProgrammer deleteTrajetProgrammer(Long id);
    public boolean isVehiculeDisponible(Long vehiculeId,TrajetProgrammer trajetProgrammer);
    public boolean isTrajetDisponible(Long trajetProgrammerId);
    public boolean isConducteurDisponible(Long conducteurId,Long trajetProgrammerId);
}
