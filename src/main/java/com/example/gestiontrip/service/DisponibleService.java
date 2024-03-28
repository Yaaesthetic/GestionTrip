package com.example.gestiontrip.service;

import java.time.LocalDate;

public interface DisponibleService {
    public boolean isSufficientSeatsAvailable(Short NbPlace, Short NbPassagers);
    public boolean isDateTrajetValide(LocalDate dateArriveePrevue, LocalDate dateDepart);
}
