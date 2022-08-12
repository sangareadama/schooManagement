package com.sang.school.schoolManagement.controller.heroku;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/public")
public class PublicApiController {
	
	 
	public PublicApiController() {}
	
	@GetMapping("test1")
	public String test1() {
		return " ici API du test 1";
	} 
	@GetMapping("test2")
	public String test2() {
		return "ici API du test 2";
	} 

}
