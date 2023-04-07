package com.example.controller;

import com.example.entity.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Users")
public class UsersRestController {
    private UsersService usersService;

    @Autowired
    public UsersRestController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    public Users add(@RequestBody Users users){
        return this.usersService.add(users);
    }

    @PutMapping
    public Users update(@RequestBody Users users){
        return this.usersService.update(users);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id ){
        return this.usersService.deleteById(id);
    }
}
