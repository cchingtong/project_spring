package com.example.repository;

import com.example.entity.Verification;
import com.example.entity.projection.VerificationProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long>{

    VerificationProjection findVerificationProjectionById(Long id);

    Page<VerificationProjection> findAllVerificationProjectionBy(PageRequest of);
}
