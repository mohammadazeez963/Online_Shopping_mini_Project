package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, String> {

}
