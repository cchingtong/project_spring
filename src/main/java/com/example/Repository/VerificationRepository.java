package com.example.Repository;

import com.example.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VerificationRepository extends JpaRepository<Verification, Long> {
}
