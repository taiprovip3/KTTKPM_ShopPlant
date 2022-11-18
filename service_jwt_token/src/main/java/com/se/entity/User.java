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

@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6990795570828179037L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role_map", joinColumns = {@JoinColumn(name = "idUser")},
//    inverseJoinColumns = {@JoinColumn(name = "idRole")})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="user_role_map",
		joinColumns = @JoinColumn(
			name="idUser",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name="idRole",
			referencedColumnName = "id"
		)
	)
	private Set<Role> roles;
	
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User() {
	}
	public User(long id, String username, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
}
