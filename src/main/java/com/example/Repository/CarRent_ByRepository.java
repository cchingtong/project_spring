package com.example.Repository;

import com.example.entity.CarRent_By;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRent_ByRepository extends JpaRepository<CarRent_By, Long> {
}
