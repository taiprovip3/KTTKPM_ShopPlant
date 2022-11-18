package com.example.crud_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_cart.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
