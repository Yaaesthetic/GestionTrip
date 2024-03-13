package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

}
