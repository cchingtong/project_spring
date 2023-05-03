package com.example.service.impl;


import com.example.configuration.exceptions.NotFoundException;
import com.example.entity.Verification;
import com.example.entity.projection.VerificationProjection;
import com.example.entity.response.ApiStatus;
import com.example.entity.response.Pagination;
import com.example.repository.VerificationRepository;
import com.example.service.VerificationService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationRepository verificationRepository;
    @Autowired
    public VerificationServiceImpl(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    @Override
    public Verification add(Verification verification) {
        Verification ver = new Verification();
        ver.setVerify_identify_number(verification.getVerify_identify_number());
        ver.setSelfie_url((ver.getSelfie_url()));
        ver.setVerify_driving_license(ver.getVerify_driving_license());
        ver.setAddress(verification.getAddress());
        return verificationRepository.save(verification);
    }
    @Override
    public Verification update(Verification verification) {
        Verification ver = verificationRepository.findById(verification.getId())
                .orElseThrow(() -> new NotFoundException(
                        ApiStatus.NOT_FOUND.getCode(),
                        ApiStatus.NOT_FOUND.getMessage()
                ));
        ver.setVerify_identify_number(verification.getVerify_identify_number());
        ver.setSelfie_url((ver.getSelfie_url()));
        ver.setVerify_driving_license(ver.getVerify_driving_license());
        ver.setAddress(verification.getAddress());
        return verificationRepository.save(ver);
    }

    @Override
    public boolean delete(Long id) {
        Verification ver = verificationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage()));
        if(!ObjectUtils.isEmpty(ver)){
            verificationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Verification findBy(Long id) {
        return this.verificationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage()));
    }

    @Override
    public VerificationProjection findVerificationProjectionById(Long id) {
        return this.verificationRepository.findVerificationProjectionById(id);
    }
    @Override
    public List<VerificationProjection>  findVerificationProjectionAll(Pagination pagination){
        Page<VerificationProjection> ver = verificationRepository.findAllVerificationProjectionBy(
                PageRequest.of(pagination.getPage()-1, pagination.getSize())
        );
        pagination.setTotalCounts(ver.getTotalElements());
        return ver.getContent();
    }


}
