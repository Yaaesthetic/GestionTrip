package com.example.gestiontrip.exception;

public class VehiculeExceptions extends RuntimeException {
    public VehiculeExceptions(String s) {
        super("Vehicle Exceptions: "+s);
    }
}
