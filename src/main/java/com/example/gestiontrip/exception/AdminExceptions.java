package com.example.gestiontrip.exception;

public class AdminExceptions extends RuntimeException {
    public AdminExceptions(String s) {
        super("Vehicle Exceptions: "+s);
    }
}