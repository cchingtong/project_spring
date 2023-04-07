package com.example.controller;

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleRestController {

    public RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public Role add(@RequestBody Role role){
        return this.roleService.add(role);
    }

    @PutMapping
    public Role update(@RequestBody Role role ){
        return this.roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.roleService.deleteById(id);
    }
}
