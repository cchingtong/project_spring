package com.example.service;

import com.example.entity.Role;
public interface RoleService {
    Role add(Role role);
    Role update(Role role); // modify the position or rank of staff
    boolean deleteById(Long id);
    Role findById(Long id);
}
