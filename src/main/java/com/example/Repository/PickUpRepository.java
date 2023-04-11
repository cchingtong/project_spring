package com.example.Repository;
import com.example.entity.PickUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PickUpRepository extends JpaRepository<PickUp, Long> {
}
