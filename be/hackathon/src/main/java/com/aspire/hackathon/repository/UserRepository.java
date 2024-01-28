package com.aspire.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspire.hackathon.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	User findByEmail(String email);
	User findByName(String name);
	
}
