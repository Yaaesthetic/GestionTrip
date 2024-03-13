package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.Account;
import com.example.gestiontrip.model.Conducteur;
import org.springframework.data.repository.CrudRepository;

public interface ConducteurRepository extends CrudRepository<Conducteur,Long> {
}
