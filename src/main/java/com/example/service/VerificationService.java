package com.example.service;

import com.example.entity.Verification;

public interface VerificationService {

    Verification add(Verification verification);
    Verification update(Verification verification);
    boolean deleteById(Long id);
}
