package com.se.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CartPK implements Serializable{
	
	private int plant;
	private int user;
	
	public CartPK() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(plant, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartPK other = (CartPK) obj;
		return plant == other.plant && user == other.user;
	}
}
