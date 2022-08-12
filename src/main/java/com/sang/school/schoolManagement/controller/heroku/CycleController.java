package com.sang.school.schoolManagement.controller.heroku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.service.ICycleService;

@Controller
@RequestMapping("/")
public class CycleController {
	
	@Autowired
	ICycleService iCycleService;
	
	
	@RequestMapping({"admin/cycle/list","admin/cycle"})
	public String ListeCycle(Model model) {
		
		List<Cycle> c = iCycleService.listeCycle(); 
		
		model.addAttribute("cycles",c);
		
		return "admin/cycle/liste_cycle";
	} 
	
	@RequestMapping("admin/cycle/add")
	public String addCycle(Model model) {
		
		model.addAttribute("cycle", new Cycle());
		
		return "/admin/cycle/add_cycle"; 
	}
	
	@RequestMapping("admin/cycle/save")
	public String SaveCycle(Cycle cycle) {
		
		iCycleService.enregistrerCycle(cycle);
		
		return "redirect:/admin/cycle";
	}
	
	@RequestMapping("admin/cycle/delete")
	public String deleteCycle(Long  id) {

		iCycleService.supprimerCycleParId(id);
		
		return "redirect:/admin/cycle";
	}
	
	@RequestMapping("admin/cycle/edit")
	public String editCycle(Model model ,Long id) {
		
		Cycle c = iCycleService.rechercherCycleParId(id);
		
		model.addAttribute("cycle", c);
		
		return "/admin/cycle/add_cycle"; 
	}
	

}
