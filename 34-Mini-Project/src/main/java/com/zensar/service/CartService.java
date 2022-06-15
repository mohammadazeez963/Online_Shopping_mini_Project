package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Cart;
import com.zensar.bean.Product;
import com.zensar.db.CartDAO;

@Service
public class CartService {

	@Autowired
	CartDAO dao;

	public Cart addProductToCart(Cart cart, Product product, int qut) {
		cart.getProducts().put(product, qut);
		return this.dao.save(cart);
	}

	public Cart removeProductFromCart(Cart cart, Product product) {
		cart.getProducts().remove(product);
		return this.dao.save(cart);
	}

	public Cart updateProductQuantity(Product product, Cart cart, int qut) {
		cart.getProducts().put(product, qut);
		return this.dao.save(cart);

	}

	public Cart removeAllProducts(Cart cart) {
		cart.getProducts().clear();
		return this.dao.save(cart);

	}

}