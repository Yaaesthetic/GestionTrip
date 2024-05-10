package com.example.gestiontrip.exception;

public class GestionnaireExceptions extends RuntimeException {
    public GestionnaireExceptions(String s) {
        super("Vehicle Exceptions: "+s);
    }
}