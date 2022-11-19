package com.se.service;

import java.util.List;

import com.se.entity.Plant;

public interface PlantService {
	public List<Plant> findAllPlant();
	public Plant findPlantById(int idPlant);
	public void savePlant(Plant plant);
	public void deletePlant(int theId);
}
