//package com.example.controller;
//
//import com.example.entity.Role;
//import com.example.entity.projection.RoleProjection;
//import com.example.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/role")
//public class RoleController {
//
//    public RoleService roleService;
//
//    @Autowired
//    public RoleController(RoleService roleService){
//        this.roleService = roleService;
//    }
//
//    @PostMapping
//    public Role add(@RequestBody Role role){
//        return this.roleService.add(role);
//    }
//
//    @PutMapping
//    public Role update(@RequestBody Role role ){
//        return this.roleService.update(role);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable Long id){
//        return this.roleService.deleteById(id);
//    }
//
//    @GetMapping("/{id}")
//    public Role findById(@PathVariable Long id){
//        return this.roleService.findById(id);
//    }
//    @GetMapping
//    public List<RoleProjection> findById(){
//        return this.roleService.findAll();
//    }
//}
