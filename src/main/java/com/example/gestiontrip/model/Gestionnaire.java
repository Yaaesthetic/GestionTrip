package com.example.gestiontrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Gestionnaire")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gestionnaire")
    private Long id;

}
