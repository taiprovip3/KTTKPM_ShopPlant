package com.se.entity;

import java.io.Serializable;


public class User implements Serializable{
	
	private int idUser;
	
	private String name;
	private String gendor;
	
	private String phoneNumber;
	
	private String email;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGendor() {
		return gendor;
	}

	public void setGendor(String gendor) {
		this.gendor = gendor;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public User(int idUser, String name, String gendor, String phoneNumber, String email) {
		this.idUser = idUser;
		this.name = name;
		this.gendor = gendor;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + idUser + ", name=" + name + ", gendor=" + gendor + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}
}
