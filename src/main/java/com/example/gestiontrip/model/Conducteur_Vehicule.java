package com.example.gestiontrip.model;

import jakarta.persistence.*;

@Entity
public class Conducteur_Vehicule {
    @EmbeddedId
    private Conducteur_VehiculeComposite idComposite;

}