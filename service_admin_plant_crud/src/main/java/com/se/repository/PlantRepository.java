package com.se.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.se.entity.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
