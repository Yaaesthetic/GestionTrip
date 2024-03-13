package com.example.gestiontrip.repository;

import com.example.gestiontrip.model.TrajetProgrammer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetProgrammerRepository extends CrudRepository<TrajetProgrammer, Long> {

}
