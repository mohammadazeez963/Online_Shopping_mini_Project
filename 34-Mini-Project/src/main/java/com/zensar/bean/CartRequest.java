package com.zensar.bean;

public class CartRequest {
	Cart cart;
	Product product;
	int quantity;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartRequest [cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
	}

}