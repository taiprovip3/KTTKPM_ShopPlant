package com.example.crud_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_cart.entity.Cart;
import com.example.crud_cart.entity.Plant;
import com.example.crud_cart.service.CartService;
import com.example.crud_cart.service.PlantService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/cart_service")
public class CartController {

	private int attempts = 1;

	private CartService cartService;
	private PlantService plantService;

	@Autowired
	public CartController(CartService cartService, PlantService plantService) {
		this.cartService = cartService;
		this.plantService = plantService;
	}

	@GetMapping("/carts/{idUser}")
	@Retry(name = "flightSearch", fallbackMethod = "fallback_retry")
	public List<Cart> getCartOfUser(@PathVariable int idUser) {
		System.out.println("item service call attempted:::" + attempts++);
//		List<Cart> carts = cartService.getCartOfUser(idUser);
		throw new RuntimeException();
//		System.out.println("item service called");
//		return carts;
	}

	public List<Cart> fallback_retry(Exception e) {
		attempts = 1;
		return null;
	}

	@PostMapping("/carts")
	public Cart saveCart(@RequestBody Cart cart) {
		Plant plant = plantService.findById(cart.getPlant().getIdPlant());
		double total = cart.getQuantity() * plant.getPrice();
		cart.setTotal(total);
		return cartService.saveCart(cart);
	}

	@DeleteMapping("/carts/{idPlant}&&{idUser}")
	public long deleteCart(@PathVariable int idPlant, @PathVariable int idUser) {
		return cartService.deleteCart(idPlant, idUser);
	}
}
