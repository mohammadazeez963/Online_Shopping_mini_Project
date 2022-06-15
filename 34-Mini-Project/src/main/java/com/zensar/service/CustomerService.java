package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Customer;
import com.zensar.db.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO dao;

	public Customer addCustomer(Customer customer) {
		return this.dao.save(customer);
	}

	public Customer updateCustomerById(Customer customer, String id) {
		return this.dao.save(customer);
	}

	public boolean removeCustomer(String customerId) {
		this.dao.deleteById(customerId);

		if (dao.findById(customerId) != null) {
			return false;
		}
		return true;
	}

	public List<Customer> viewAllCustomer() {
		return this.dao.findAll();
	}

}