package com.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.se.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
