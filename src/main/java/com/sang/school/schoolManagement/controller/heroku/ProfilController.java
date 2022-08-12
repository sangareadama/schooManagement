package com.sang.school.schoolManagement.controller.heroku;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfilController {
	
	@GetMapping("index")
	public String index() {
		return "profile/index";
	} 
}
