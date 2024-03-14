package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.TrajetProgrammerExceptions;
import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.repository.TrajetProgrammerRepository;
import com.example.gestiontrip.service.TrajetProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrajetProgrammerServiceImpl implements TrajetProgrammerService {
    private final TrajetProgrammerRepository trajetProgrammerRepository;
    @Autowired
    public TrajetProgrammerServiceImpl(TrajetProgrammerRepository trajetProgrammerRepository) {
        this.trajetProgrammerRepository = trajetProgrammerRepository;
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
            throw new TrajetProgrammerExceptions("TrajetProgrammer not found with id: " + id);
        }
    }
    @Override
    public TrajetProgrammer createTrajetProgrammer(TrajetProgrammer TrajetProgrammer) {
        return trajetProgrammerRepository.save(TrajetProgrammer);
    }
    @Override
    public TrajetProgrammer updateTrajetProgrammer(Long id, TrajetProgrammer TrajetProgrammer) {
        if (trajetProgrammerRepository.existsById(id)) {
            TrajetProgrammer.setIdTrajetProgrammer(id);
            return trajetProgrammerRepository.save(TrajetProgrammer);
        } else
            throw new TrajetProgrammerExceptions("Unable to update. TrajetProgrammer not found with id: " + id);
    }
    @Override
    public void deleteTrajetProgrammer(Long id) {
        if (trajetProgrammerRepository.existsById(id))
            trajetProgrammerRepository.deleteById(id);
        else
            throw new TrajetProgrammerExceptions("Unable to delete. TrajetProgrammer not found with ID: " + id);

    }
}