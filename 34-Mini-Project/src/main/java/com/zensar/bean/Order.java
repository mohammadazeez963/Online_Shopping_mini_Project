package com.zensar.bean;

import java.time.LocalDate;
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
@Table(name = "orders")
public class Order {
	@Id
	private String orderId;
	private LocalDate orderDate;
	private String orderstatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
	@ElementCollection
	@CollectionTable(name = "order_product_mapping", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "quantity")
	private Map<Product, Integer> productions;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;

	public Order(String orderId, LocalDate orderDate, String orderstatus, Customer customer, Map productions,
			Address address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderstatus = orderstatus;
		this.customer = customer;
		this.productions = productions;
		this.address = address;
	}

	public Order() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map getProductions() {
		return productions;
	}

	public void setProductions(Map productions) {
		this.productions = productions;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderstatus=" + orderstatus + ", customer="
				+ customer + ", productions=" + productions + ", address=" + address + "]";
	}

}