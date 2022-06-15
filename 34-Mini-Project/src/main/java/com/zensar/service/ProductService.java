package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Order;
import com.zensar.bean.Product;
import com.zensar.db.ProductDAO;

@Service
public class ProductService {

	@Autowired
	ProductDAO dao;
	
	public List<Product> viewAllProducts() {
		return this.dao.findAll();
	}

	public Product addProduct(Product product) {
		return this.dao.save(product);

	}

	public Product findByProductId(String productId) {

		Optional<Product> optional = this.dao.findById(productId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	public Product updateProductById(Product product, int id) {
		return this.dao.save(product);
	}

	

	public boolean removeProduct(String productId) {

		Optional<Product> optional = this.dao.findById(productId);
		if (optional.isPresent()) {
			this.dao.deleteById(productId);
			return true;
		}
		return false;
	}
}