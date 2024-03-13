package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "PermisType")
public class PermisType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type de permis")
    private Type type;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date de delivrance")
    private Date dateDelivrance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    @ManyToOne
    @JoinColumn(name = "IDConducteur")
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
