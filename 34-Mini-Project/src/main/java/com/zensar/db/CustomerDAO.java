package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, String>{

}
