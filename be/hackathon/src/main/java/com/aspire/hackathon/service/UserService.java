package com.aspire.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.aspire.hackathon.model.User;
import com.aspire.hackathon.repository.UserRepository;
import com.aspire.hackathon.utils.JwtUtils;

@Component
public class UserService {
	
	private UserRepository userRepository;
	private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
	
    @Autowired
    public void UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }
	 
	 public ResponseEntity<?> save(User user) {
		 if (userRepository.findByEmail(user.getEmail()) != null) {
			 return ResponseEntity.badRequest().body("Email already exists");
		 }

		 userRepository.save(user);
		 return ResponseEntity.ok("User created successfully");
	 }

	 public ResponseEntity<?> get(User user) throws Exception{
		 
		 if(user.getEmail() == null) {
			 return ResponseEntity.badRequest().body("Invalid Email ID");
		 }

		 User existingUser = userRepository.findByEmail(user.getEmail());
		 
		 if(existingUser == null){
			 return ResponseEntity.badRequest().body("User does not exist");
		 }
		 
		 try{
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(existingUser.getName(), existingUser.getPassword()));
		 }catch(BadCredentialsException e){
			 throw new Exception("Bad Credentials... Invalid user");
		 }  

		 existingUser.setToken("Bearer " + jwtUtils.generateToken(existingUser));

		 return ResponseEntity.ok(existingUser);
	 }
}
