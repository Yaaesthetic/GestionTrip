package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Administrateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur extends Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrator")
    private Long idAdministrator;
}
