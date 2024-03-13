package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.Account;
import com.example.gestiontrip.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
