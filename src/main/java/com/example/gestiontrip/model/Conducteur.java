package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Conducteur")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDConducteur")
    private Long iDConducteur;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prénom")
    private String prenom;

    @Column(name = "Matricule")
    private String matricule;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date de naissance")
    private Date dateNaissance;

    @Column(name = "Numéro de Permis")
    private String permisNumber;

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    @OrderBy("dateDelivrance ASC") // Optional: Order by date of issuance

    private Set<PermisType> permisTypes ; // Set with a maximum size of 9

    public void addPermisType(PermisType permisType) {
        if (permisTypes.size() < 9) {
            permisTypes.add(permisType);
            permisType.setConducteur(this);
        } else {
            System.err.println("the maximum number of PermisType is reached");
        }
    }
}