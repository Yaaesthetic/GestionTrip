package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.Account;
import com.example.gestiontrip.model.Vehicule;
import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends CrudRepository<Vehicule,Long> {
}
