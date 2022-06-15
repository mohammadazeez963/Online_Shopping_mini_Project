package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

}
