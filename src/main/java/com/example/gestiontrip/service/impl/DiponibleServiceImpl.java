package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.service.DisponibleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiponibleServiceImpl implements DisponibleService {
    @Override
    public boolean isSufficientSeatsAvailable( Short NbPlace, Short NbPassagers){
        return NbPlace > NbPassagers;
    }
    @Override
    public boolean isDateValide( LocalDate dateArriveePrevue, LocalDate dateDepart) {
        return dateArriveePrevue.isAfter(dateDepart);
    }
}