package com.zensar.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bean.Order;
import com.zensar.service.OrderService;

@RestController
public class OrderRestController {
	@Autowired
	OrderService service;

	@PostMapping("/order/add")
	public Order f1(@RequestBody Order order) {
		return this.service.addOrder(order);
	}

	@GetMapping("/order/find/{Id}")
	public Order f2(@PathVariable(name = "Id") String Id) {
		return this.service.viewByOrderId(Id);
	}

	@PutMapping("/order/update/{Id}")
	public Order f3(@RequestBody Order order, @PathVariable(name = "Id") String Id) {
		return this.service.updateOrderById(order, Id);
	}

	@GetMapping("/order/getall")
	public List<Order> f5() {
		return this.service.viewAllOrders();
	}
	@DeleteMapping("/order/delete/{Id}")
	public boolean f6(@RequestBody Order order, @PathVariable(name = "Id") String Id) {
		return this.service.removeOrder(Id);
	}
}