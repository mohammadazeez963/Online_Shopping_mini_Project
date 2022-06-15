package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Address;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{

}
