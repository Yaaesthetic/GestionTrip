package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.Account;
import com.example.gestiontrip.model.Administrateur;
import org.springframework.data.repository.CrudRepository;

public interface AdministrateurRepository extends CrudRepository<Administrateur,Long> {
}
