package com.se.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7663756688410704131L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_permission_map", joinColumns = {@JoinColumn(name = "idRole")},
    inverseJoinColumns = {@JoinColumn(name = "idPermission")})
	private Set<Permission> permissions;
	
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
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Role() {
	}
	public Role(long id, String name, Set<Permission> permissions) {
		super();
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
	}
}
