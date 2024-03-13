package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

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
    @Column(name = "DateArriveeReel")
    private Date DateArriveReel;
    private LocalTime HereArriveReel;
    private Date DateDepartReel;
    private LocalTime HeureDepartReel;
}
