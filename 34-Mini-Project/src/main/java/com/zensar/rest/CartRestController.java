package com.zensar.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.bean.Cart;
import com.zensar.bean.CartRequest;
import com.zensar.bean.Product;
import com.zensar.db.ProductDAO;
import com.zensar.service.CartService;

@RestController
public class CartRestController {

	@Autowired
	CartService service;

	@PostMapping(value = "/addproducttocart")
	public Cart f1(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		int quantity = request.getQuantity();
		return this.service.addProductToCart(cart, product, quantity);
	}

	@DeleteMapping(value = "/removeproductfromcart")
	public Cart f2(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		return this.service.removeProductFromCart(cart, product);
	}

	@PutMapping(value = "/updateproductcart")
	public Cart f3(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		int quantity = request.getQuantity();
		return this.service.updateProductQuantity(product,cart,quantity);
	}

	@DeleteMapping(value = "/removeallfromcart")
	public Cart f4(@RequestBody Cart cart) {
		return this.service.removeAllProducts(cart);
	}

}