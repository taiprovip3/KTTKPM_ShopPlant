package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Plant;
import com.se.service.PlantService;

@RestController
@RequestMapping("/admin")
public class PlantController {
	@Autowired
	private PlantService plantService;
	
	@GetMapping("plants")
	public List<Plant> listStudent() {
		List<Plant> plants = plantService.findAllPlant(); 
		return plants;
	}
	
	@GetMapping("plants/{idPlant}")
	public Plant findOneStudent(@PathVariable int id) {
		Plant plant = plantService.findPlantById(id);
		return plant;
	}
	
	@PostMapping("plants")
	public Plant addPlant(@RequestBody Plant plant) {
		plantService.savePlant(plant);
		return plant;
	}
	
	@PutMapping("plants")
	public Plant updatePlant( @RequestBody Plant plant) {
		plantService.savePlant(plant);
		return plant;
	}
	
	@DeleteMapping("/plants/{idPlant}")
	public String deletePlant(@PathVariable int id) {
		Plant plant = plantService.findPlantById(id);
		if (plant== null) {
			throw new 	RuntimeException("plant id not found = " + id);
		}
		
		plantService.deletePlant(id);
		
		return "Delete plant id = "+ id;
	}
}
