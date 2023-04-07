package com.example.service;

import com.example.entity.Role;
public interface RoleService {
    Role add(Role role);
    Role update(Role role);
    boolean deleteById(Long id);
}
