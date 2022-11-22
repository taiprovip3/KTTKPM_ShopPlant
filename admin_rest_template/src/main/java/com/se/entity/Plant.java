package com.se.entity;

public class Plant {

	private long id;
	private String name;
	private double price;
	private int quantity;
	private String category;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Plant() {
		super();
	}
	public Plant(long id, String name, double price, int quantity, String category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Plant [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + ", description=" + description + "]";
	}
	
}
