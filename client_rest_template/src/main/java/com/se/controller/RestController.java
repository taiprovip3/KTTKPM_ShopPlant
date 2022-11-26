package com.se.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.se.entity.Cart;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/client_rest_template")
public class RestController {

	private RestTemplate restTemplate;
	private String url = "http://localhost:8084/cart_service/carts/";
	private int attempts = 1;
	
	@Autowired
	public RestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/carts/{idUser}")
//	@CircuitBreaker(name = "CIRCUIT_BREAKER_1", fallbackMethod = "fallback_retry")
//	@Retry(name = "RETRY_1", fallbackMethod = "fallback_retry")
	public List<Cart> getCartOfUser(@PathVariable int idUser) {
		System.out.println("Lần gọi thứ " + attempts++);
		ResponseEntity<List<Cart>> responseEntity = restTemplate.exchange(url+idUser, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Cart>>() {});
		System.out.println("Gọi thành công!");
		return responseEntity.getBody();
	}

	public List<Cart> fallback_retry(Exception e) {
		attempts = 1;
		return null;
	}
	
	@DeleteMapping("/carts/{idPlant}&&{idUser}")
	@TimeLimiter(name = "TIME_LIMITER_1")
	public CompletableFuture<Void> removeCart(@PathVariable int idPlant, @PathVariable int idUser) {
 		return CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
//					restTemplate.delete(url+idPlant+"&&"+idUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
