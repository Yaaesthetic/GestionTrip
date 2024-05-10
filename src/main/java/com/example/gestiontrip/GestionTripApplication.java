package com.example.gestiontrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GestionTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionTripApplication.class, args);
    }

}