package com.aspire.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.hackathon.model.User;
import com.aspire.hackathon.service.MyUserDetailsService;
import com.aspire.hackathon.service.UserService;
import com.aspire.hackathon.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class AuthController {
	
    private UserService userService;

	@Autowired
    public AuthController(UserService userService) {
    	this.userService = userService;
    }
	    
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
    	return userService.save(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> oginUser(@RequestBody User user) throws Exception {
    	return userService.get(user);
    }
}
