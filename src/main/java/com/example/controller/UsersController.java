package com.example.controller;

import com.example.entity.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    private UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    public Users add(@RequestBody Users users){
        //....
        return this.usersService.add(users);

    }

    @PutMapping
    public Users update(@RequestBody Users users){
        //...
        return this.usersService.update(users);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id ){
        this.usersService.deleteById(id);
        return "delete user";
    }
}
