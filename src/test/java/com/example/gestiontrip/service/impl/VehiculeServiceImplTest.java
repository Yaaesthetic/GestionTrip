package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.repository.VehiculeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehiculeServiceImplTest {
    @Mock
    private VehiculeRepository vehiculeRepository;

    @InjectMocks
    private VehiculeServiceImpl vehiculeService;

    @BeforeEach
    void setUp() {
        // Additional setup if needed before each test method
    }

    @AfterEach
    void tearDown() {
        // Additional cleanup if needed after each test method
    }

    @Test
    void getAllVehicules() {
        when(vehiculeRepository.findAll()).thenReturn(() -> );

    }

    @Test
    void getVehiculeById() {
    }

    @Test
    void createVehicule() {
    }

    @Test
    void updateVehicule() {
    }

    @Test
    void deleteVehicule() {
    }
}