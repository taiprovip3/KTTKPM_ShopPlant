package com.se.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Token implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6243711454594684732L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(columnDefinition = "TEXT")
	private String token;
	private Date tokenExpDate;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(
			name= "createdBy",
			referencedColumnName = "id"
	)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenExpDate() {
		return tokenExpDate;
	}

	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Token() {
		super();
	}

	public Token(long id, String token, Date tokenExpDate, User user) {
		super();
		this.id = id;
		this.token = token;
		this.tokenExpDate = tokenExpDate;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", token=" + token + ", tokenExpDate=" + tokenExpDate + ", user=" + user + "]";
	}
}
