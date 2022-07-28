package com.sang.school.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.domain.TypeCours;
import com.sang.school.schoolManagement.service.ITypeCoursService;

@Controller
@RequestMapping("/")
public class TypeCoursController {
	
	@Autowired
	ITypeCoursService iTypeCoursService;
	
	@RequestMapping({"admin/typeCours/list","admin/typeCours"})
	public String ListeTypeCours(Model model) {
			       	
		List<TypeCours> tc = iTypeCoursService.listeTypeCours();
		
		model.addAttribute("typeCours",tc);
		
		return "admin/typeCours/liste_typeCours";
	} 
	
	@RequestMapping("admin/typeCours/add")
	public String addTypeCours(Model model) {        
      
		model.addAttribute("typeCours", new TypeCours());
		
		return "/admin/typeCours/add_typeCours"; 
	}
	     
	@RequestMapping("admin/typeCours/save")
	public String SaveTypeCours(TypeCours typeCours) {
		
		iTypeCoursService.enregistrerTypeCours(typeCours);
		
		return "redirect:/admin/typeCours";
	}
	 
	@RequestMapping("admin/typeCours/delete")
	public String deleteTypeCours(Long  id) {

		iTypeCoursService.supprimerTypeCoursParId(id);
		
		return "redirect:/admin/typeCours";
	}
	
	@RequestMapping("admin/typeCours/edit")  
	public String editTypeCours(Model model ,Long id) {
		
		TypeCours tc = iTypeCoursService.rechercherTypeCoursParId(id);
		  
		model.addAttribute("typeCours", tc);
		
		return "/admin/typeCours/add_typeCours"; 
	}
	

}
