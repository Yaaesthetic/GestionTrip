package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Person")
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Person")
    private Long idPerson;

    private String nom;
    private String prenom;
    private String cin;
    private LocalDate dateNaissance;
}
