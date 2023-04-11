package com.example.Repository;

import com.example.entity.CarRent_invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface CarRent_invoiceRepository extends JpaRepository<CarRent_invoice, Long> {
}
