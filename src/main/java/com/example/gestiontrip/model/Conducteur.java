package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Conducteur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur {
    @Id
    @GeneratedValue
    @Column(name = "ID_Conducteur")
    private Long idConducteur;

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
    private Date dateNaissance;

    @Column(name = "PermisNumber")
    private String permisNumber;

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    @OrderBy("dateDelivrance ASC")
    private Set<PermisType> permisTypes = new HashSet<>();

    public void addPermisType(PermisType permisType) {
        if (permisTypes.size() < 9) {
            permisTypes.add(permisType);
            permisType.setConducteur(this);
        } else {
            throw new IllegalStateException("The maximum number of PermisType is reached");
        }
    }

}
