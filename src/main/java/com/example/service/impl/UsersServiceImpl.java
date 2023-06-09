package com.example.service.impl;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users add(Users users) {
//        users.setCreatedBy("Admin");
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        //...
        Users us = this.usersRepository.findById(users.getId()).orElse(null);
        if (us == null) {
            return null;
        }
        return this.usersRepository.save(us);
    }

    @Override
    public boolean deleteById(Long id) {
        //...
        Users us = this.usersRepository.findById(id).orElse(null);
        if (us == null) {
            return false;
        }
        this.usersRepository.deleteById(id);
        return true;
    }

    @Override
    public Users findById(Long id) {
        return this.usersRepository.findById(id).orElse(null);
    }
}