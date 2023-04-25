package com.example.Repository;

import com.example.entity.Car;
import com.example.entity.projection.CarProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<CarProjection> findByName(String name);

    @Override
    List<Car> findAll();

    Page<CarProjection> findAllCarProjectionBy(Pageable pageable);
}
