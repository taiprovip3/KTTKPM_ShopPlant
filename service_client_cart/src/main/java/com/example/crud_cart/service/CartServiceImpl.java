package com.example.crud_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.crud_cart.entity.Cart;
import com.example.crud_cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.saveCart(cart);
	}

	@Override
	public long deleteCart(int idPlant, int idUser) {
		return cartRepository.deleteCart(idPlant, idUser);
	}

	@Override
	@Cacheable(value = "cartCache")
	public List<Cart> getCartOfUser(int idUser) {
		return cartRepository.getCartOfUser(idUser);
	}

}
