package com.example.service.impl;


import com.example.entity.Verification;
import com.example.repository.VerificationRepository;
import com.example.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;


public class VerificationServiceImpl implements VerificationService {

    final VerificationRepository verificationRepository;
    @Autowired
    public VerificationServiceImpl(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    @Override
    public Verification add(Verification verification) {
        verification.setCreatedBy("Admin");
        return this.verificationRepository.save(verification);
    }

    @Override
    public Verification update(Verification verification) {
        Verification ver = this.verificationRepository.findById(verification.getId()).orElse(null);
        if (ver == null) {
            return null;
        }
        return this.verificationRepository.save(ver);
    }

    @Override
    public boolean deleteById(Long id) {
        Verification ver = (Verification)this.verificationRepository.findById(id).orElse(null);
        if (ver == null){
            return false;
        }
        this.verificationRepository.deleteById(id);
        return true;
    }
}
