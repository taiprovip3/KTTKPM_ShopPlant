package com.example.Admin.service;

import java.util.List;

import com.example.Admin.entity.Plant;

public interface PlantService {
	public List<Plant> findAllPlant();
	public Plant findPlantById(int idPlant);
	public void savePlant(Plant plant);
	public void deletePlant(int theId);
}
