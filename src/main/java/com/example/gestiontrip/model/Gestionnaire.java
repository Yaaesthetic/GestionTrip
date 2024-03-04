package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_gestionnaire")
    private long idGestionnaire;

    @Column(name = "Date_depart")
    private String dateDepart;
    @Column(name = "Heure_depart")
    private String heureDepart;
    @Column(name = "Date_arrivee_prevue")
    private String dateArriveePrevue;
    @Column(name = "Heure_arrivee_prevue")
    private String heureArriveePrevue;
    @Column(name = "Depart")
    private String depart;
    @Column(name = "Destination")
    private String destination;
    @Column(name = "Type_vehicule")
    private String typeVehicule;
    @Column(name = "Nombre de passagers")
    private String nombreDePassagers;
    @Column(name = "Autres_details")
    private String autresDetails;
}
