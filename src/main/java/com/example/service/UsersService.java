package com.example.service;

import com.example.entity.Users;


public interface UsersService {

    Users add(Users users);
    Users update(Users users);
    boolean deleteById(Long id);
    Users findById(Long id);

}