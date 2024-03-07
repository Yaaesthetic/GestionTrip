package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_administrator")
    private long idAdministrator;


}
