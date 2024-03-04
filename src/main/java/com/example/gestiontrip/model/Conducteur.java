package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Conducteur")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur {
    @Id
    @Column(name = "CIN")
    private String cin;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prénom")
    private String prenom;
    @Column(name = "Matricule")
    private String matricule;
    @Column(name = "Date de naissance")
    private Date dateNaissance;
    @Column(name = "Numéro de Permis")
    private String permisNumber;
    @Column(name = "Type de permis")
    private Set<PermisType> permisType;




}
