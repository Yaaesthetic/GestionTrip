package com.example.gestiontrip.controller;

import com.example.gestiontrip.model.TrajetProgrammer;
import com.example.gestiontrip.service.TrajetProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/TrajetProgrammer")
public class TrajetProgrammerController {
    private final TrajetProgrammerService trajetProgrammer;
    @Autowired
    public TrajetProgrammerController(TrajetProgrammerService trajetProgrammer) {
        this.trajetProgrammer = trajetProgrammer;
    }
    @GetMapping
    public List<TrajetProgrammer> getAllTrajetProgrammers() {
        return trajetProgrammer.getAllTrajetProgrammers();
    }
    @GetMapping("/{id}")
    public TrajetProgrammer getTrajetProgrammerById(@PathVariable Long id) {
        return trajetProgrammer.getTrajetProgrammerById(id);
    }
    @PostMapping
    public TrajetProgrammer createTrajetProgrammer(@RequestBody TrajetProgrammer TrajetProgrammer) {
        return trajetProgrammer.createTrajetProgrammer(TrajetProgrammer);
    }
    @PutMapping("/{id}")
    public TrajetProgrammer updateTrajetProgrammer(@PathVariable Long id, @RequestBody TrajetProgrammer TrajetProgrammer) {
        return trajetProgrammer.updateTrajetProgrammer(id, TrajetProgrammer);
    }
    @DeleteMapping("/{id}")
    public void deleteTrajetProgrammer(@PathVariable Long id) {
        trajetProgrammer.deleteTrajetProgrammer(id);
    }
}