package com.example.Repository;

import com.example.entity.MotorRent_By;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MotorRent_ByRepository extends JpaRepository<MotorRent_By, Long>{
}
