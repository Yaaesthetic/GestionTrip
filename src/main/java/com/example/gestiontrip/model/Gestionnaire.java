package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Gestionnaire")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire {
    @Id
    @GeneratedValue
    @Column(name = "ID_Gestionnaire")
    private Long idGestionnaire;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Is_Active")
    private boolean isActive;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "CIN")
    private String cin;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Naissance")
    private LocalDate dateNaissance;

}
