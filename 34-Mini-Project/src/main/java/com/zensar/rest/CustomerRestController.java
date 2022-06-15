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

import com.zensar.bean.Customer;
import com.zensar.service.CustomerService;

@RestController
public class CustomerRestController {
	@Autowired
	CustomerService service;

	@PostMapping("/customer/add")
	public Customer f1(@RequestBody Customer customer) {
		return this.service.addCustomer(customer);
	}

	@PutMapping("/customer/update/{Id}")
	public Customer f2(@RequestBody Customer customer, @PathVariable(name = "Id") String Id) {
		return this.service.updateCustomerById(customer, Id);
	}

	@DeleteMapping("/customer/delete/{id}")
	public boolean f3(@PathVariable(name = "id") String id) {
		return service.removeCustomer(id);
	}

	@GetMapping("/customer/getall")
	public List<Customer> f4() {
		return this.service.viewAllCustomer();
	}

}