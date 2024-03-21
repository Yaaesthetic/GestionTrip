package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.VehiculeExceptions;
import com.example.gestiontrip.model.Conducteur;
import com.example.gestiontrip.model.PermisType;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.ConducteurRepository;
import com.example.gestiontrip.repository.VehiculeRepository;
import com.example.gestiontrip.service.ConducteurService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VehiculeServiceImplTest {
    private VehiculeRepository vehiculeRepository;

    private VehiculeServiceImpl vehiculeService;

   /* @Mock
    private ConducteurRepository conducteurRepository;*/

    private ConducteurService conducteurService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        // Additional cleanup if needed after each test method
    }

    /*@Test
    void getAllConducteurs() {
        // Arrange
        List<Conducteur> conducteurs = new ArrayList<>();
        conducteurs.add(new Conducteur(*//* construct a Conducteur object *//*));
        when(conducteurRepository.findAll()).thenReturn(conducteurs);

        // Act
        List<Conducteur> result = conducteurService.getAllConducteurs();

        // Assert
        assertNotNull(result);
        assertEquals(conducteurs, result);
    }*/

    @Test
    void getAllNoVehicules() {
        when(vehiculeRepository.findAll()).thenReturn(Collections.emptySet());

        //List<Vehicule> result = vehiculeService.getAllVehicules();

        //assertNotNull(result);
        assertThrows(VehiculeExceptions.class,()->vehiculeService.getAllVehicules());
    }
    @Test
    void getAllExistedVehicules() {
        List<Vehicule> vehiculeList=Arrays.asList(Vehicule.builder().idVehicule(1L).typeVehicule("A").disponibilite(true).immatriculation("abc").kilometrage(123).marque("toyota").modele("supra").nbPlace((short) 123).typePermisRequis(PermisType.Type.C).build(),
                Vehicule.builder().idVehicule(2L).typeVehicule("B").disponibilite(false).immatriculation("abc").kilometrage(123).marque("toyota").modele("supra").nbPlace((short) 123).typePermisRequis(PermisType.Type.C).build()
        );
        vehiculeRepository.saveAll(vehiculeList);

        when(vehiculeRepository.findAll()).thenReturn(vehiculeList);

        List<Vehicule> result = vehiculeService.getAllVehicules();

        assertNotNull(result);
        assertEquals(vehiculeList,result);
    }

    @ParameterizedTest

    @Test
    void getVehiculeById() {
        //when(vehiculeRepository.findById())

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