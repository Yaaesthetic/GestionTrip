package com.example.gestiontrip.service;

import com.example.gestiontrip.model.Administrateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<Administrateur> getAllAdmins();
    Administrateur getAdminById(Long id);
    Administrateur createAdmin(Administrateur admin);
    Administrateur updateAdmin(Long id, Administrateur admin);
    void deleteAdmin(Long id);
}