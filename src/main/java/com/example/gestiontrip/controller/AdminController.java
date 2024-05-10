package com.example.gestiontrip.controller;

import com.example.gestiontrip.model.Administrateur;
import com.example.gestiontrip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/administrateurs")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Administrateur> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Administrateur getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    public Administrateur createAdmin(@RequestBody Administrateur admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/{id}")
    public Administrateur updateAdmin(@PathVariable Long id, @RequestBody Administrateur admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}
