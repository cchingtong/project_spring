package com.example.repository;

import com.example.entity.Users;
import com.example.entity.projection.UsersProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    Optional<UsersProjection> findUserProjectionById(Long id);

    Page<UsersProjection> findUsersProjectionByFirstnameContainingIgnoreCase(String firstname, PageRequest of);
}