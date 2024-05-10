package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.TrajetProgrammerExceptions;
import com.example.gestiontrip.exception.VehiculeExceptions;
import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.ConducteurRepository;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import com.example.gestiontrip.repository.VehiculeRepository;
import com.example.gestiontrip.service.TrajetProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrajetProgrammerServiceImpl implements TrajetProgrammerService {

    private final TrajetProgrammerRepository trajetProgrammerRepository;
    private final DiponibleServiceImpl diponibleServiceImpl;
    private final VehiculeServiceImpl vehiculeServiceImpl;
    private final ConducteurServiceImpl conducteurServiceImpl;
@Autowired
    public TrajetProgrammerServiceImpl(TrajetProgrammerRepository trajetProgrammerRepository, DiponibleServiceImpl diponibleServiceImpl, VehiculeServiceImpl vehiculeServiceImpl, ConducteurServiceImpl conducteurServiceImpl) {
        this.trajetProgrammerRepository = trajetProgrammerRepository;
        this.diponibleServiceImpl = diponibleServiceImpl;
        this.vehiculeServiceImpl = vehiculeServiceImpl;
        this.conducteurServiceImpl = conducteurServiceImpl;
}

    @Override
    public List<TrajetProgrammer> getAllTrajetProgrammers() {
        Iterable<TrajetProgrammer> TrajetProgrammersIterable = trajetProgrammerRepository.findAll();
        List<TrajetProgrammer> TrajetProgrammersList = new ArrayList<>();
        TrajetProgrammersIterable.forEach(TrajetProgrammersList::add);
        if (TrajetProgrammersList.isEmpty()) {
            throw new TrajetProgrammerExceptions("No TrajetProgrammers found");
        }
        return TrajetProgrammersList;
    }
    @Override
    public TrajetProgrammer getTrajetProgrammerById(Long id){
        Optional<TrajetProgrammer> optionalTrajetProgrammer = trajetProgrammerRepository.findById(id);
        if (optionalTrajetProgrammer.isPresent()) {
            return optionalTrajetProgrammer.get();
        } else {
            throw new TrajetProgrammerExceptions("TrajetProgrammer not found with ID=" + id);
        }
    }
    @Override
    public TrajetProgrammer createTrajetProgrammer(TrajetProgrammer trajetProgrammer) {
        if (isTrajetDisponible(trajetProgrammer.getIdTrajetProgrammer()))
            throw new TrajetProgrammerExceptions("Unable to create. TrajetProgrammer not found with ID=" + trajetProgrammer.getIdTrajetProgrammer());
        if (isVehiculeDisponible(trajetProgrammer.getIdVehicule(),trajetProgrammer.getIdVehicule()))
            throw new TrajetProgrammerExceptions("Unable to create. TrajetProgrammer not found with ID=" + trajetProgrammer.getIdTrajetProgrammer());
        return trajetProgrammerRepository.save(trajetProgrammer);
    }
    @Override
    public TrajetProgrammer deleteTrajetProgrammer(Long id) {
        Optional<TrajetProgrammer> optionalTrajetProgrammer = trajetProgrammerRepository.findById(id);
        if (optionalTrajetProgrammer.isPresent()) {
            TrajetProgrammer deletedTrajetProgrammer = optionalTrajetProgrammer.get();
            trajetProgrammerRepository.deleteById(id);
            return deletedTrajetProgrammer;
        } else {
            throw new TrajetProgrammerExceptions("Unable to delete. TrajetProgrammer not found with ID=" + id);
        }
    }

    @Override

    public boolean isTrajetDisponible(Long trajetProgrammerId){
        Optional<TrajetProgrammer> trajet = trajetProgrammerRepository.findById(trajetProgrammerId);
        if(trajet.isPresent()) {
            TrajetProgrammer trajetProgrammer=trajet.get();
            return diponibleServiceImpl.isDateValide(trajetProgrammer.getDateArriveePrevue(),trajetProgrammer.getDateDepart());
        }
        return false;
    }
    @Override
    public boolean isVehiculeDisponible(Long vehiculeId,Long trajetProgrammerId){
        Optional<TrajetProgrammer> trajetProgrammerOptional = trajetProgrammerRepository.findById(trajetProgrammerId);
        if(trajetProgrammerOptional.isPresent()) {
            TrajetProgrammer trajetProgrammer=trajetProgrammerOptional.get();
            Vehicule vehicule = vehiculeServiceImpl.getVehiculeById(vehiculeId);

            return (diponibleServiceImpl.isSufficientSeatsAvailable(vehicule.getNbPlace(), trajetProgrammer.getNbPassagers())
                    && vehicule.getTypeVehicule().toString().equals(trajetProgrammer.getTypeVehicule())
                    && vehiculeServiceImpl.isVehiculeTimeDisponible(vehiculeId, trajetProgrammer.getDateDepart(), trajetProgrammer.getDateArriveePrevue()));

        } else throw new TrajetProgrammerExceptions("TrajetProgrammer not found with ID=" + trajetProgrammerId);
    }
    @Override
    public boolean isConducteurDisponible(Long conducteurId,Long trajetProgrammerId){
        Optional<TrajetProgrammer> trajetProgrammerOptional = trajetProgrammerRepository.findById(trajetProgrammerId);
        if(trajetProgrammerOptional.isPresent()) {
            TrajetProgrammer trajetProgrammer=trajetProgrammerOptional.get();
            Conducteur conducteur = conducteurServiceImpl.getConducteurById(conducteurId);
                return  (conducteurServiceImpl.isConducteurTimeDisponible(conducteurId, trajetProgrammer.getDateDepart(), trajetProgrammer.getDateArriveePrevue())
                        && conducteur.getPermisTypes().toString().equals(trajetProgrammer.getTypeVehicule()));

        } else throw new TrajetProgrammerExceptions("TrajetProgrammer not found with ID=" + trajetProgrammerId);
    }


    @Override
    public TrajetProgrammer updateTrajetProgrammer(Long id, TrajetProgrammer TrajetProgrammer) {
        if (trajetProgrammerRepository.existsById(id)) {
            TrajetProgrammer.setIdTrajetProgrammer(id);
            return trajetProgrammerRepository.save(TrajetProgrammer);
        } else
            throw new TrajetProgrammerExceptions("Unable to update. TrajetProgrammer not found with ID=" + id);
    }


}