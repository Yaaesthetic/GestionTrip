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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrajetProgrammer;

    private LocalDate dateDepart;
    private LocalTime heureDepart;
    private LocalDate dateArriveePrevue;
    private LocalTime heureArriveePrevue;

    private String depart;
    private String destination;
    private String typeVehicule;
    private Short nbPassagers;
    private String autresDetails;

    private boolean status = false;
    private Long idVehicule;
    private Long idConducteur;
}
