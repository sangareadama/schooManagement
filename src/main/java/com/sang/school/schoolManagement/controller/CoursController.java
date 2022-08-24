package com.sang.school.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.domain.Niveau;
import com.sang.school.schoolManagement.domain.TypeCours;
import com.sang.school.schoolManagement.model.ModelCours;
import com.sang.school.schoolManagement.service.ICoursService;
import com.sang.school.schoolManagement.service.ITypeCoursService;

@Controller
@RequestMapping("/")
public class CoursController {
	
	@Autowired
	ICoursService iCoursService;
	
	@Autowired
	ITypeCoursService iTypeCoursService;
	
	@RequestMapping({"admin/cours/list","admin/cours"})
	public String ListeCours(Model model) {
		
		List<Cours> c = iCoursService.listeCours();
		
		model.addAttribute("cours",c); 
		
		return "admin/cours/liste_cours";
	}
	 
	@RequestMapping("admin/cours/add")
	public String addCours(Model model) {
		
		System.out.println(";;;;;;;;;;;;;;;;; c'est bon");
		
		model.addAttribute("cours", new ModelCours());
		
		List<TypeCours> tc = iTypeCoursService.listeTypeCours();
		
		model.addAttribute("typeCours",tc);
		
		return "/admin/cours/add_cours"; 
	}
	
	@RequestMapping("admin/cours/save")
	public String SaveCourse(ModelCours modelCours) {
		
		TypeCours tc = iTypeCoursService.rechercherTypeCoursParId(modelCours.getTypeCourId());
		
		iCoursService.enregistrerCours(modelCours.getLibelle(),tc); 
		
		return "redirect:/admin/cours";
	}
	
	@RequestMapping("admin/cours/delete")
	public String deleteCours(Long  id) {

		iCoursService.supprimerCoursParId(id);
		
		return "redirect:/admin/cours";
	}
	
	@RequestMapping("admin/cours/edit")
	public String editCours(Model model ,Long id) {
		
		Cours c = iCoursService.rechercherCoursParId(id);
		
		model.addAttribute("cours", c);
		
		List<TypeCours> tc = iTypeCoursService.listeTypeCours();
		
		model.addAttribute("typeCours",tc);
		
		return "/admin/cours/edit_cours"; 
	}

	
	@RequestMapping("admin/cours/update")
	public String updateNiveau(Cours cours) {
		
		TypeCours tc = iTypeCoursService.rechercherTypeCoursParId(cours.getTypeCours().getId());
		
		iCoursService.modifierCoursParId(cours.getId(), cours.getLibelle(), tc);
		
		return "redirect:/admin/cours";
	} 
}
