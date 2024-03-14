package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Conducteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur extends Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDConducteur")
    private Long idConducteur;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Matricule")
    private String matricule;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateNaissance")
    private Date dateOfBirth;

    @Column(name = "PermisNumber")
    private String permisNumber;

    @Column(name = "Disponibilite")
    private boolean disponibilite;

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    @OrderBy("dateDelivrance ASC") // Optional: Order by date of issuance
    private Set<PermisType> permisTypes = new HashSet<>();

    public void addPermisType(PermisType permisType) {
        if (permisTypes.size() < 9) {
            permisTypes.add(permisType);
            permisType.setConducteur(this);
        } else {
            System.err.println("The maximum number of PermisType is reached");
        }
    }
}
