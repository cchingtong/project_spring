package com.example.service.impl;


import com.example.entity.Role;

import com.example.repository.RoleRepository;

import com.example.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;


public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;
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
}