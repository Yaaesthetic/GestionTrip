package com.example.gestiontrip.controller;

import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Conducteur")
public class ConducteurController {
    private final ConducteurService conducteurService;
    @Autowired
    public ConducteurController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }
    @GetMapping
    public List<Conducteur> getAllConducteurs() {
        return conducteurService.getAllConducteurs();
    }
    @GetMapping("/{id}")
    public Conducteur getConducteurById(@PathVariable Long id) {
        return conducteurService.getConducteurById(id);
    }
    @PostMapping
    public Conducteur createConducteur(@RequestBody Conducteur conducteur) {
        return conducteurService.createConducteur(conducteur);
    }
    @PutMapping("/{id}")
    public Conducteur updateConducteur(@PathVariable Long id, @RequestBody Conducteur conducteur) {
        return conducteurService.updateConducteur(id, conducteur);
    }
    @DeleteMapping("/{id}")
    public void deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteConducteur(id);
    }
}