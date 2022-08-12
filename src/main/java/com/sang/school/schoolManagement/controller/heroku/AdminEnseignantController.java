package com.sang.school.schoolManagement.controller.heroku;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enseignant")
public class AdminEnseignantController {
	
	
	@RequestMapping({"/dashboard","/"})
	public String dashboardPage() {
		return "adminEnseignant/dashboard";
	} 
	

}
