package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Trajet Programmer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrajetProgrammer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrajetProgramer;
    private Date dateDepart;
    private LocalTime heureDepart;
    private Date dateArrivePrevue;
    private LocalTime heureArrivePrevue;
    private String depart;
    private String destination;
    private String typeVehicule;
    private Short nbPassagers;
    private String autresDetails;
    private boolean status = false;
    private Long idVehicule;

}
