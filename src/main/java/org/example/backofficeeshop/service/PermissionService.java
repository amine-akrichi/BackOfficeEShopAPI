package org.example.backofficeeshop.service;

import org.example.backofficeeshop.model.Permission;
import org.example.backofficeeshop.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    public List<Permission> getPermissionByRoleLibelle(String roleLibelle) {
        return permissionRepository.getPermissionByRoleLibelle(roleLibelle);
    }
}
