package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.VehiculeExceptions;
import com.example.gestiontrip.model.PermisType;
import com.example.gestiontrip.model.Vehicule;
import com.example.gestiontrip.repository.VehiculeRepository;
import com.example.gestiontrip.service.ConducteurService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@SpringBootTest

class VehiculeServiceImplTest {

    @Autowired
    private VehiculeServiceImpl vehiculeService;
    private List<Vehicule> vehiculeList;
    @BeforeEach
    void setUp() {
        vehiculeList = Arrays.asList(
                Vehicule.builder().immatriculation("1234-56|أ|7").marque("Toyota").modele("C").typeVehicule(PermisType.Type.A).kilometrage(10000).nbPlace((short) 6).disponibilite(true).build(),
                Vehicule.builder().immatriculation("1234-99|أ|7").marque("Toyota").modele("C").typeVehicule(PermisType.Type.A).kilometrage(10000).nbPlace((short) 6).disponibilite(true).build()
        );
    }
    @Test
    void getAllNoVehicules() {
        Throwable exception = assertThrows(VehiculeExceptions.class, () -> vehiculeService.getAllVehicules());

        assertEquals("Vehicle Exceptions: No Vehicules found", exception.getMessage());

    }
    @Test
    void getAllExistedVehicules() {
        vehiculeList.forEach(vehiculeService::createVehicule);

        List<Vehicule> result = vehiculeService.getAllVehicules();

        assertNotNull(result);
        assertEquals(vehiculeList, result);

        vehiculeList.forEach(v -> vehiculeService.deleteVehicule(v.getIdVehicule()));
    }
    @Test
    void getVehiculeById() {
        Vehicule vehicule = vehiculeService.createVehicule(vehiculeList.get(0));
        assertNotNull(vehicule);

        Long vehiculeById = vehiculeService.getVehiculeById(vehicule.getIdVehicule()).getIdVehicule();
        assertNotNull(vehiculeById);

        assertEquals(vehicule.getIdVehicule(), vehiculeById);

        vehiculeService.deleteVehicule(vehiculeById);
    }
    @Test
    void createVehicule() {
        Vehicule vehicule = vehiculeService.createVehicule(vehiculeList.get(0));
        assertNotNull(vehicule);

        Long vehiculeById = vehiculeService.getVehiculeById(vehicule.getIdVehicule()).getIdVehicule();
        vehiculeService.deleteVehicule(vehiculeById);
    }
    @Test
    void updateVehicule() {
        Vehicule vehicule = vehiculeService.createVehicule(vehiculeList.get(0));
        assertNotNull(vehicule);

        Vehicule updatedVehicule = vehiculeService.updateVehicule(vehicule.getIdVehicule(), vehiculeList.get(1));
        assertNotNull(updatedVehicule);

        assertEquals(updatedVehicule, vehiculeService.getVehiculeById(vehicule.getIdVehicule()));

        vehiculeService.deleteVehicule(vehicule.getIdVehicule());
    }
    @Test
    void deleteVehicule() {
        Vehicule vehicule = vehiculeService.createVehicule(vehiculeList.get(0));
        assertNotNull(vehicule);

        Vehicule deletedVehicule = vehiculeService.deleteVehicule(vehicule.getIdVehicule());
        assertNotNull(deletedVehicule);

        assertThrows(VehiculeExceptions.class, () -> vehiculeService.getVehiculeById(vehicule.getIdVehicule()));
    }
}
/*
@Mock
    private ConducteurRepository conducteurRepository;*/
/*
    private ConducteurService conducteurService;
*/
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
//    static List<Object> vehiculeList(){
//        return Arrays.asList(new Object[][] {
//            { 1L,vehiculeList.get(0)},
//            { 2L,vehiculeList.get(1)}
//    });
//    }