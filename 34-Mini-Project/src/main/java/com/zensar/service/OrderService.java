package com.zensar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Order;
import com.zensar.db.OrderDAO;

@Service
public class OrderService {
	@Autowired
	OrderDAO dao;

	public Order addOrder(Order order) {
		return this.dao.save(order);
	}

	public Order updateOrderById(Order order, String id) {
		return this.dao.save(order);
	}

	public boolean removeOrder(String orderId) {
		
		Optional<Order> optional = this.dao.findById(orderId);
		if (optional.isPresent())
			{this.dao.deleteById(orderId);
			return true;}
		return false;
	}

	public Order viewByOrderId(String orderId) {
		Optional<Order> optional = this.dao.findById(orderId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	public List<Order> viewAllOrders(LocalDate date) {
		List<Order> allOrders = this.dao.findAll();
		List<Order> filteredOrders = new ArrayList<>();
		for (Order order : allOrders) {
			if (order.getOrderDate().equals(date)) {
				filteredOrders.add(order);
			}
		}
		return filteredOrders;
	}

	public List<Order> viewAllOrders() {
		return this.dao.findAll();
	}
}