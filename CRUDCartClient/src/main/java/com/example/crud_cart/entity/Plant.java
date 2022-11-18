package com.example.crud_cart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plant")
	private int idPlant;
	
	private String name;
	private double price;
	private int quantity;
	
	public int getIdPlant() {
		return idPlant;
	}
	public void setIdPlant(int idPlant) {
		this.idPlant = idPlant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Plant() {
	}
	public Plant(int idPlant, String name, double price, int quantity) {
		this.idPlant = idPlant;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Plant [idPlant=" + idPlant + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
