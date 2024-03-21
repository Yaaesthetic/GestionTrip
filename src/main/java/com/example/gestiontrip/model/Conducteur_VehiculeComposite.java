package com.example.gestiontrip.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Conducteur_VehiculeComposite implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ID_Administrateur")
    private Administrateur administrateur;

    @ManyToOne
    @JoinColumn(name = "ID_Conducteur")
    private Conducteur conducteur;

}