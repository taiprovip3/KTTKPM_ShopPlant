package com.se.entity;

import java.io.Serializable;


public class Cart implements Serializable{

	private Plant plant;
	
	private User user;

	private int quantity;
	private double total;
	
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Cart() {
	}
	public Cart(Plant plant, User user, int quantity, double total) {
		this.plant = plant;
		this.user = user;
		this.quantity = quantity;
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Cart [plant=" + plant + ", user=" + user + ", quantity=" + quantity + ", total=" + total + "]";
	}
}
