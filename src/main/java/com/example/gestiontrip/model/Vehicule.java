package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicule")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Vehicule")
    private Long idVehicule;

    @Column(name = "Immatriculation")
    private String immatriculation;

    @Column(name = "Marque")
    private String marque;

    @Column(name = "Modele")
    private String modele;
    @Enumerated(EnumType.STRING)
    @Column(name = "TypeVehicule")
    private PermisType.Type  typeVehicule;

    @Column(name = "Kilometrage")
    private int kilometrage;

    @Column(name = "Disponibilite")
    private boolean disponibilite = false;

    @Column(name = "NbPlace")
    private short nbPlace;
}
