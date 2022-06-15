package com.zensar.bean;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
	@Id
	private String cartId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
	@ElementCollection
	@CollectionTable(name = "cart_product_mapping", joinColumns = {
			@JoinColumn(name = "cartId", referencedColumnName = "cartId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "quantity")
	private Map<Product, Integer> products;

	public Cart(String cartId, Customer customer, Map products) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.products = products;
	} 

	public Cart() {
		super();
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map getProducts() {
		return products;
	}

	public void setProducts(Map products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", products=" + products + "]";
	}

}