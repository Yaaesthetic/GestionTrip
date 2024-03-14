package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Voyage")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Voyage")
    private long idVoyage;

    @Column(name = "Date_Arrivee_Reelle")
    private LocalDate dateArriveeReelle;

    @Column(name = "Heure_Arrivee_Reelle")
    private LocalTime heureArriveeReelle;

    @Column(name = "Date_Depart_Reelle")
    private LocalDate dateDepartReelle;

    @Column(name = "Heure_Depart_Reelle")
    private LocalTime heureDepartReelle;
}
