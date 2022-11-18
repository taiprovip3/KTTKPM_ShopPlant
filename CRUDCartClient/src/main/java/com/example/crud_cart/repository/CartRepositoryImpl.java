package com.example.crud_cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crud_cart.entity.Cart;

@Repository
public class CartRepositoryImpl implements CartRepository {

	private EntityManager entityManager;

	@Autowired
	public CartRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Cart saveCart(Cart cart) {
		return entityManager.merge(cart);
	}

	@Override
	@Transactional
	public long deleteCart(int idPlant, int idUser) {
		Query query = entityManager.createQuery("delete from Cart where id_plant=:idPlant and id_user=:idUser");
		query.setParameter("idPlant", idPlant);
		query.setParameter("idUser", idUser);
		return query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Cart> getCartOfUser(int idUser) {
		Query query = entityManager.createQuery("from Cart where id_user=:idUser");
		query.setParameter("idUser", idUser);
		return query.getResultList();
	}
}
