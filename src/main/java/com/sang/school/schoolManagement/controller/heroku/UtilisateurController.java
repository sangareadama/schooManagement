package com.sang.school.schoolManagement.controller.heroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.school.schoolManagement.domain.Utilisateur;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("admin/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurService iUtilisateurService;
	
	/*
	 * @GetMapping() public String utilisateur(Model model) { List<Utilisateur> ut =
	 * iUtilisateurService.listeUtilisateur(); model.addAttribute("utilisateur",ut);
	 * 
	 * return null; } 
	 */
	@ModelAttribute("utilisateur")
	public Utilisateur utilisateur() {	
		return new Utilisateur();
	} 
	
	@GetMapping
	public String retrouverPage() {
		return "admin/utilisateur";
		
	} 
	
	@PostMapping
	public String enregistrerUtilisateur(@ModelAttribute("utilisateur")Utilisateur utilisateur ) {
	    	
	  // iUtilisateurService.enregistrerUtilisateur(utilisateur);
		 
		return "redirect:/admin/utilisateur?succes";
		
	}
	
	//@ModelAttribute("utilisateur")Utilisateur utilisateur
}
