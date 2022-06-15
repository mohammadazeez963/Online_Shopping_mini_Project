package com.zensar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Address;
import com.zensar.db.AddressDAO;

@Service
public class AddressService {

	@Autowired
	AddressDAO dao;

	public Address addAddress(Address address) {
		return this.dao.save(address);
	}

	public Address findByAddressId(int addressId) {

		Optional<Address> optional = this.dao.findById(addressId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	public Address updateAddressById(Address address, int id) {
		Optional<Address> add = dao.findById(id);
		if (add != null) {
			return dao.save(address);
		}
		return null;
	}

	public List<Address> getAllAddresses() {
		return this.dao.findAll();
	}
	
	public boolean removeAddress(int addressId) {
		Optional<Address> optional = dao.findById(addressId);
		if (optional != null) {
		this.dao.deleteById(addressId);
		return true;
		}
		else {
		return false;
		}
		}

}