package com.authenticator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authenticator.config.JwtGenerator;
import com.authenticator.entity.User;
import com.authenticator.service.UserService;
import com.authenticator.service.impl.LoginForm;

@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	@PostMapping("/authen/login")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
		
		User userLoggedIn = userService.findByUsernameAndPassword(
			loginForm.getUsername(), loginForm.getPassword());
		
		if (userLoggedIn != null) {
			return ResponseEntity.ok(jwtGenerator.generateToken(userLoggedIn));
		}
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
