package com.example.repository;

import com.example.entity.Role;
import com.example.entity.projection.RoleProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    List<RoleProjection> findAllBy();

    Page<RoleProjection> findAllRoleProjectionBy(PageRequest of);
}