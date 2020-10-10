package com.project.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.project.auth.model.AuthRequest;
import com.project.auth.model.AuthResponse;
import com.project.auth.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authentication(@RequestBody AuthRequest authRequest) {
		try {
			AuthResponse response = new AuthResponse();
			String jwt = authService.authenticate(authRequest);
			response.setJwt(jwt);
			return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "unauthorized");
		}
	}
	
	@GetMapping("/home")
	public String home() {
		return "Hello World!";
	}
}
