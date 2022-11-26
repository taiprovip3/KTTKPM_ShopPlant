package com.se;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.se.entity.Plant;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class ServiceAdminPlantCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAdminPlantCrudApplication.class, args);
	}

}
