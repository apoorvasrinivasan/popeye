package com.aspire.hackathon.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aspire.hackathon.model.User;
import com.aspire.hackathon.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	UserRepository userRepository;
	
	public MyUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
	}

}
