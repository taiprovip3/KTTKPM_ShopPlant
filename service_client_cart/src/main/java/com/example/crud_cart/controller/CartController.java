package com.example.crud_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

@RestController
@RequestMapping("/cart_service")
public class CartController {
	
	private CartService cartService;
	private PlantService plantService;
    private RedisTemplate template;

	
	@Autowired
	public CartController(CartService cartService, PlantService plantService, RedisTemplate template) {
		this.cartService = cartService;
		this.plantService = plantService;
		this.template = template;
	}

	@GetMapping("/carts/{idUser}")
	public List<Cart> getCartOfUser(@PathVariable int idUser){
		List<Cart> carts = cartService.getCartOfUser(idUser);
//		Map<Integer, Cart> cartMap = carts.stream().collect(Collectors.toMap(Cart::getQuantity, Function.identity()));
//		template.opsForList().rightPushAll("carts", carts);
//		System.out.println(template.opsForList().range("carts", 0, 1000));
		return carts;
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
