package com.se.dto;

import java.io.Serializable;

public class UserDTO {
	private long id;
	private String username;
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDTO() {
		super();
	}
	public UserDTO(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
