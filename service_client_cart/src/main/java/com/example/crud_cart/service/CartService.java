package com.example.crud_cart.service;

import java.util.List;

import com.example.crud_cart.entity.Cart;

public interface CartService {
	public Cart saveCart(Cart cart);
	public long deleteCart(int idPlant, int idUser);
	public List<Cart> getCartOfUser(int idUser);
}
