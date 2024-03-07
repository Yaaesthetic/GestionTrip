package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private Date DateDepart;
    private LocalTime HeureDepart;
    private Date DateArrivePrevue;
    private LocalTime HeureArrivePrevue;
    private String Depart;
    private String Destination;
    private String TypeVehicule;
    private Short NbPassagers;
    private String AutresDetails;
    private boolean Status = false;

}
