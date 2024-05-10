package com.example.gestiontrip.controller;

import com.example.gestiontrip.model.Gestionnaire;
import com.example.gestiontrip.service.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/gestionnaires")
public class GestionnaireController {
    private final GestionnaireService gestionnaireService;

    @Autowired
    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    @GetMapping
    public List<Gestionnaire> getAllGestionnaires() {
        return gestionnaireService.getAllGestionnaires();
    }

    @GetMapping("/{id}")
    public Gestionnaire getGestionnaireById(@PathVariable Long id) {
        return gestionnaireService.getGestionnaireById(id);
    }

    @PostMapping
    public Gestionnaire createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
        return gestionnaireService.createGestionnaire(gestionnaire);
    }

    @PutMapping("/{id}")
    public Gestionnaire updateGestionnaire(@PathVariable Long id, @RequestBody Gestionnaire gestionnaire) {
        return gestionnaireService.updateGestionnaire(id, gestionnaire);
    }

    @DeleteMapping("/{id}")
    public void deleteGestionnaire(@PathVariable Long id) {
        gestionnaireService.deleteGestionnaire(id);
    }
}
