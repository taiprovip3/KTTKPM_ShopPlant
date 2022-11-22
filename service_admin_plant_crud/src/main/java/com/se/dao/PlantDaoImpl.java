package com.se.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Plant;
import com.se.repository.PlantRepository;

@Service
@Transactional
public class PlantDaoImpl {
	
	private PlantRepository plantRepository;
	
	@Autowired
	public PlantDaoImpl(PlantRepository plantRepository) {
		this.plantRepository = plantRepository;
	}
	
	public List<Plant> getPlants(){
		return (List<Plant>) plantRepository.findAll();
	}
	
	public Plant getPlantById(Long id) {
		System.out.println(id);
		Optional<Plant> pOptional = plantRepository.findById(id);
		if(pOptional.isPresent()) {
			Plant plant = pOptional.get();
			System.out.println(plant);
			return plant;
		}
		System.out.println("Not found!");
		return null;
	}
	
	public Plant savePlant(Plant plant) {
		return plantRepository.save(plant);
	}
	
	public void removePlantById(Long id) {
		plantRepository.deleteById(id);
	}
	
}
