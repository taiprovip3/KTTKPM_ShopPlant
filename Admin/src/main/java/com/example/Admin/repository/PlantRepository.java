package com.example.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Admin.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
