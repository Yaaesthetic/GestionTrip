package com.example.gestiontrip.service.impl;

import com.example.gestiontrip.exception.AdminExceptions;
import com.example.gestiontrip.model.Administrateur;
import com.example.gestiontrip.repository.AdministrateurRepository;
import com.example.gestiontrip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public AdminServiceImpl(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public List<Administrateur> getAllAdmins() {
        Iterable<Administrateur> adminsIterable = administrateurRepository.findAll();
        List<Administrateur> adminsList = new ArrayList<>();
        adminsIterable.forEach(adminsList::add);
        if (adminsList.isEmpty()) {
            throw new AdminExceptions("No admins found");
        }
        return adminsList;
    }

    @Override
    public Administrateur getAdminById(Long id) {
        Optional<Administrateur> optionalAdmin = administrateurRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            return optionalAdmin.get();
        } else {
            throw new AdminExceptions("Admin not found with ID=" + id);
        }
    }

    @Override
    public Administrateur createAdmin(Administrateur admin) {
        return administrateurRepository.save(admin);
    }

    @Override
    public Administrateur updateAdmin(Long id, Administrateur admin) {
        if (administrateurRepository.existsById(id)) {
            admin.setIdAdministrateur(id);
            return administrateurRepository.save(admin);
        } else {
            throw new AdminExceptions("Unable to update. Admin not found with ID=" + id);
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        Optional<Administrateur> optionalAdmin = administrateurRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            administrateurRepository.deleteById(id);
        } else {
            throw new AdminExceptions("Unable to delete. Admin not found with ID=" + id);
        }
    }
}
