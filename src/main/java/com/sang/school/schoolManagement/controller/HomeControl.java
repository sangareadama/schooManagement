package com.sang.school.schoolManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControl {
	
	/*
	 * @GetMapping("index") public String index() { return "index"; }
	 * 
	 * @GetMapping("/") public String home() { return "index"; }
	 * 
	 */
	
	
	@GetMapping("fragments")
	public String fragments() {
		return "fragments";
	}

}
