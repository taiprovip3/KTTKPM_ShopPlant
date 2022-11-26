package com.se.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.se.entity.Plant;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/admin_rest_template") //http://localhost:8086/admin_rest_template/plants/
public class RestController {

	private RestTemplate restTemplate;
	private final String SERVICE_ADMIN_PLANT_CRUD_URL = "http://localhost:8085/service_admin_plant_crud/plants/";
	private int ATTEMP_RETRY = 1;
	private long idToDelete = 0;
	
	@Autowired
	public RestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/plants/generate")
	public String generatePlantsData() {
		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVICE_ADMIN_PLANT_CRUD_URL + "/generate",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<String>() {}
		);
		return responseEntity.getBody();
	}
	

//	@CircuitBreaker(name = "CIRCUIT_BREAKER_1", fallbackMethod = "getFakeListPlant")
//	@Retry(name = "RETRY_1", fallbackMethod = "getFakeListPlant")
//	@RateLimiter(name = "RATE_LIMITER_1", fallbackMethod = "getFakeListPlant")
	@GetMapping("/plants")
	public List<Plant> findAllPlant() {
//		System.out.println("Method findAllPlant() retry " + ATTEMP_RETRY++ + " times at " + LocalDateTime.now() + "\n\n");
		ResponseEntity<List<Plant>> responseEntity = restTemplate.exchange(
				SERVICE_ADMIN_PLANT_CRUD_URL,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Plant>>() {}
		);
		List<Plant> plants = responseEntity.getBody();
		return plants;
	}

//	@GetMapping("/plants")
//	@TimeLimiter(name = "TIME_LIMITER_1")
//	public CompletableFuture<Void> removePlant() {
// 		return CompletableFuture.runAsync(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(1000);
//					ResponseEntity<List<Plant>> responseEntity = restTemplate.exchange(
//						SERVICE_ADMIN_PLANT_CRUD_URL,
//						HttpMethod.GET,
//						null,
//						new ParameterizedTypeReference<List<Plant>>() {}
//					);
////					System.out.println(responseEntity.getBody());
//					System.out.println("Tác vụ sau 3s mới thực hiện được");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public List<Plant> getFakeListPlant(Exception e) {
		return Stream.of(
				new Plant(1, "Connection Error", 100.000, 111, "Something was error", "Resilience4J - Retry - TimeLimiter, CircuitBreaker, RateLimiter!")
		).collect(Collectors.toList());
	}

}
