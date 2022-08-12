package com.sang.school.schoolManagement.controller.heroku;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccesController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
}
