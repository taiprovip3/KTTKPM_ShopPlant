package com.example.crud_cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_cart.entity.Plant;
import com.example.crud_cart.repository.PlantRepository;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantRepository plantRepository;
	
	@Override
	public Plant findById(int idPlant) {
		Optional<Plant> result = plantRepository.findById(idPlant);
		return result.get();
	}

}
