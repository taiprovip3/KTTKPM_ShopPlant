package com.se.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.dao.PlantDaoImpl;
import com.se.entity.Plant;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/service_admin_plant_crud") //http://localhost:8085/service_admin_plant_crud/plants/
public class ApiRestController {

	private PlantDaoImpl plantDaoImpl;
	
	@Autowired
	public ApiRestController(PlantDaoImpl plantDaoImpl) {
		this.plantDaoImpl = plantDaoImpl;
	}
	
	@GetMapping("/plants/generate")
	public String generatePlant() {
		for(int i=1; i<1000; i++) {
			Plant plant = new Plant();
			plant.setId(i);
			plant.setName("Tree Plant " + i);
			plant.setCategory("Dioxit " + i);
			plant.setDescription("The best choice for decorate house green with tree oxygen air cover house!");
			plant.setPrice(100.000);
			plant.setQuantity(i);
			plantDaoImpl.savePlant(plant);
		}
		return "Generated success.";
	}

	@CachePut(value = "Plants_Hash")
	@GetMapping("/plants")
	public List<Plant> getPlans(){
		return plantDaoImpl.getPlants();
	}

	@Cacheable(value = "Plant", key = "#id")
	@GetMapping("/plants/{id}")
	public Plant getPlanById(@PathVariable long id) {
		System.out.println("Saved plant `" + id + "` to cache!");
		return plantDaoImpl.getPlantById(id);
	}
	
	@CachePut(value = "Plant", key = "#Plant.id")
	@PostMapping("/plants")
	public Plant savePlant(@RequestBody Plant plant) {
		return plantDaoImpl.savePlant(plant);
	}
	
	@CacheEvict(value = "Plant", allEntries = true)
	@DeleteMapping("/plants/{id}")
	public String removePlant(@PathVariable long id) {
		try {
			plantDaoImpl.removePlantById(id);
			return "Remove a plant successfully!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Something error when delete!";
	}
	
	@GetMapping("/plants/hello_world")
	@RateLimiter(name = "RATE_LIMITER_1")
	public ResponseEntity<String> helloWorld() {
		System.out.println("Server said hello world!");
		return new ResponseEntity<String>("Hello World from server!", HttpStatus.OK);
	}
}
