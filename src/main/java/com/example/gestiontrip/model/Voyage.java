package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Voyage")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Voyage")
    private Long idVoyage;
    @Column(name = "DateArriveeReel")
    private LocalDate DateArriveReel;
    private LocalTime HereArriveReel;
    private LocalDate DateDepartReel;
    private LocalTime HeureDepartReel;
    private Long idTrajetPrograme;

}
