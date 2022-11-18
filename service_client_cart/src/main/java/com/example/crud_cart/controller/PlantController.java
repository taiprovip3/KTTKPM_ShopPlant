package com.example.crud_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_cart.entity.Plant;
import com.example.crud_cart.service.PlantService;

@RestController
@RequestMapping("/cart_service")
public class PlantController {
	
	@Autowired
	private PlantService plantService;
	
	@GetMapping("/plants/{idPlant}")
	public Plant findById(@PathVariable int idPlant) {
		return plantService.findById(idPlant);
	}
}
