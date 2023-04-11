package com.example.Repository;

import com.example.entity.MotorRent_invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRent_invoiceRepository extends JpaRepository<MotorRent_invoice, Long>{
}
