package com.se.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.se.entity.Plant;
import com.se.repository.PlantRepository;

@Service
public class PlantServiceImlp implements PlantService {
	@Autowired
	private PlantRepository plantRepository;
	
	@Override
	@Cacheable(value = "plantCache")
	public List<Plant> findAllPlant() {
		// TODO Auto-generated method stub
		return plantRepository.findAll();
	}
	
	@Override
	public Plant findPlantById(int idPlant) {
		// TODO Auto-generated method stub
		Optional<Plant> result = plantRepository.findById(idPlant);
		Plant plant = null;
		if (result.isPresent()) {
			plant = result.get();
		}
		else {
			throw new RuntimeException("Did not find plant id="+ idPlant);
		}
		return plant;
	}

	@Override
	public void savePlant(Plant plant) {
		// TODO Auto-generated method stub
		plantRepository.save(plant);
		
	}

	@Override
	public void deletePlant(int theId) {
		// TODO Auto-generated method stub
		plantRepository.deleteById(theId);
		
	}

}
