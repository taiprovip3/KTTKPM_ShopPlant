package com.se.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3163901390870778417L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String permission;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Permission() {
	}
	public Permission(long id, String permission) {
		super();
		this.id = id;
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission + "]";
	}
}
