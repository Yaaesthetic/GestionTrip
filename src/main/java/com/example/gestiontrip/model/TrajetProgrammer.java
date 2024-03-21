package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "trajet_programmer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrajetProgrammer {
    @Id
    @GeneratedValue
    @Column(name = "id_trajet_programmer")
    private Long idTrajetProgrammer;

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "heure_depart")
    private LocalTime heureDepart;

    @Column(name = "date_arrivee_prevue")
    private LocalDate dateArriveePrevue;

    @Column(name = "heure_arrivee_prevue")
    private LocalTime heureArriveePrevue;

    @Column(name = "depart")
    private String depart;

    @Column(name = "destination")
    private String destination;

    @Column(name = "type_vehicule")
    private String typeVehicule;

    @Column(name = "nb_passagers")
    private Short nbPassagers;

    @Column(name = "autres_details")
    private String autresDetails;

    @Column(name = "status")
    private boolean status = false;

    @Column(name = "id_vehicule")
    private Long idVehicule;
}
