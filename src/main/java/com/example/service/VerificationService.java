package com.example.service;

import com.example.entity.Verification;
import com.example.entity.projection.VerificationProjection;

import java.util.List;

public interface VerificationService {

    Verification add(Verification verification);
    Verification update(Verification verification);
    boolean delete(Long id);
    Verification findBy(Long id);

    VerificationProjection findVerificationProjectionById(Long id);
}