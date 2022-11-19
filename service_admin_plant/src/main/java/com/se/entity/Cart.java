package com.se.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(CartPK.class)
@Table(name = "carts")
public class Cart implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name = "idPlant")
	private Plant plant;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idUser")
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
