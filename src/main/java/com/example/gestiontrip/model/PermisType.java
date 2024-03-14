package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "permis_type")
public class PermisType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_delivrance")
    private Date dateDelivrance;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    public enum Type {
        AM, // Cyclomoteurs et petits véhicules.
        A1, // Motocyclettes légères.
        A,  // Motocyclettes.
        B,  // Conduite de voitures standard.
        C,  // Camions de taille moyenne.
        D,  // Permis pour conduire bus.
        EB, // Remorquage avec voiture.
        EC, // Camions de grande taille.
        ED  // Bus avec remorques.
    }
}
