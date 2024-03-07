package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Table(name = "Trajetplaifie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trajetplaifie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrajetPrograme;
    private LocalDate DateDepart;
    private LocalTime HeureDepart;
    private LocalDate DateArrivePrevue;
    private LocalTime HeureArrivePrevue;
    private String Depart;
    private String Destination;
    private String TypeVehicule;
    private Short NbPassagers;
    private String AutresDetails;
    private boolean Status = false;

}
