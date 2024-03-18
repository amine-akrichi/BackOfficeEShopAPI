package org.example.backofficeeshop.service;

import org.example.backofficeeshop.model.Role;
import org.example.backofficeeshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public List<Role> listAll() {
        return this.roleRepository.findAll();
    }



}
