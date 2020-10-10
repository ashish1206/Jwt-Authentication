package com.project.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.auth.model.AuthRequest;
import com.project.auth.model.AuthResponse;

@RestController
public class AuthController {
	@PostMapping("/authenticate")
	public AuthResponse authentication(@RequestBody AuthRequest authRequest) {
		return null;
	}
	
	@GetMapping("/home")
	public String home() {
		return "Hello World!";
	}
}
