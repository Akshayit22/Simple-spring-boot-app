package com.springboot.springboot_first_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public String Home() {
		return "Welcome to Springboot first project api ---> 2.2.2.2.2";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Springboot api";
	}
}
