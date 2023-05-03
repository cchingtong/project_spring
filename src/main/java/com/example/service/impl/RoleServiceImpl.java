package com.example.service.impl;


import com.example.entity.Role;
import com.example.entity.projection.RoleProjection;
import com.example.entity.response.Pagination;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
//        role.setCreatedBy("Admin");
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        Role rol = this.roleRepository.findById(role.getId()).orElse(null);
        if (rol == null) {
            return null;
        }
//        rol.setUpdatedBy("Tommy");
//        rol.setTitle(role.getTitle());
        return this.roleRepository.save(role);
    }

    @Override
    public boolean deleteById(Long id) {
        Role role = this.roleRepository.findById(id).orElse(null);
        if (role == null) {
            return false;
        }
        this.roleRepository.deleteById(id);
        return true;
    }

    @Override
    public Role findById(Long id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<RoleProjection> findAll() {
        return roleRepository.findAllBy();
    }
    @Override
    public List<RoleProjection> findRoleProjectionAll(Pagination pagination){
        Page<RoleProjection> rol = roleRepository.findAllRoleProjectionBy(
                PageRequest.of(pagination.getPage()-1, pagination.getSize())
        );
        pagination.setTotalCounts(rol.getTotalElements());
        return rol.getContent();
    }
}