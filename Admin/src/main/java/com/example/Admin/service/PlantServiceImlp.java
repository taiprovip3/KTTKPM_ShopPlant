package com.example.Admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Admin.entity.Plant;
import com.example.Admin.repository.PlantRepository;

@Service
public class PlantServiceImlp implements PlantService {
	@Autowired
	private PlantRepository plantRepository;	 
	@Override
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
