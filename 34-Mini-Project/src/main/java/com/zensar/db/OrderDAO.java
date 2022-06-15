package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, String>{

}
