package com.example.Repository;

import com.example.entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {
}
