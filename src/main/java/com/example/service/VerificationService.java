package com.example.service;

import com.example.entity.Verification;
import com.example.entity.projection.VerificationProjection;
import com.example.entity.response.Pagination;

import java.util.List;

public interface VerificationService {

    Verification add(Verification verification);
    Verification update(Verification verification);
    boolean delete(Long id);
    Verification findBy(Long id);
    List<VerificationProjection>  findVerificationProjectionAll(Pagination pagination);
    VerificationProjection findVerificationProjectionById(Long id);
}