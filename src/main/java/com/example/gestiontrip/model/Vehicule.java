package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Véhicule")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_administrator")
    private long idAdministrator;
    @Column(name = "Immatriculation")
    private String immatriculation;
    @Column(name = "Marque")
    private String marque;
    @Column(name = "Modele")
    private String modele;
    @Column(name = "TypeVehicule")
    private Date typeVehicule;
    @Column(name = "Kilometrage")
    private int kilometrage;
    @Column(name = "Disponibilite")
    private boolean disponibilite;
    @Column(name = "TypePermisRequis")
    private String typePermisRequis;
}
