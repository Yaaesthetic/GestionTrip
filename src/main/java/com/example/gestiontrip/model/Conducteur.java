package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Conducteur")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur extends Person{
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
    @Column(name = "Disponibilite")
    private boolean disponibilite;

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

    public Long getiDConducteur() {
        return iDConducteur;
    }

    public void setiDConducteur(Long iDConducteur) {
        this.iDConducteur = iDConducteur;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPermisNumber() {
        return permisNumber;
    }

    public void setPermisNumber(String permisNumber) {
        this.permisNumber = permisNumber;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Set<PermisType> getPermisTypes() {
        return permisTypes;
    }

    public void setPermisTypes(Set<PermisType> permisTypes) {
        this.permisTypes = permisTypes;
    }
}