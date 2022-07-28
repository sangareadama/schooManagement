package com.sang.school.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sang.school.schoolManagement.dao.IniveauDao;
import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.domain.Niveau;
import com.sang.school.schoolManagement.model.ModelNiveau;
import com.sang.school.schoolManagement.service.ICycleService;
import com.sang.school.schoolManagement.service.INiveauService;

@Controller
@RequestMapping("/")
public class NiveauController {
	
	@Autowired
	INiveauService iNiveauService;
	
	@Autowired
	IniveauDao iNiveauDao;
	
	@Autowired
	ICycleService iCycleService;
	 
	
	
	@RequestMapping({"/admin/niveau/list","/admin/niveau"})
	public String ListeNiveau(Model model) {
		
		List<Niveau> niv = iNiveauService.listeNiveau();
		
		model.addAttribute("niveaux",niv);
		
		return "admin/niveau/niveau";
	} 
	@RequestMapping("admin/niveau/add")
	public String addNiveau(Model model) {
		
		model.addAttribute("niveau", new ModelNiveau());
		
        List<Cycle> c = iCycleService.listeCycle();
		
		model.addAttribute("cycles",c);
		
		return "/admin/niveau/add_niveau"; 
	}
	
	@RequestMapping("admin/niveau/save")
	public String SaveNiveau(ModelNiveau modelNiveau) {
		
	  Cycle c = iCycleService.rechercherCycleParId(modelNiveau.getCycleId());
	  
	  iNiveauService.enregistrerNiveau(modelNiveau.getLibelle(), c);
		
		return "redirect:/admin/niveau";
	}
	
	@RequestMapping("admin/niveau/delete")
	public String deleteNiveau(Long  id) {
		
		iNiveauService.supprimerNiveauParId(id);
		
		return "redirect:/admin/niveau";
	}
	@RequestMapping("admin/niveau/edit")
	public String editNiveau(Model model ,Long id) {
		
		Niveau nv = iNiveauService.rechercherNiveauParId(id);
		
		model.addAttribute("niveau", nv);
		
		 List<Cycle> c = iCycleService.listeCycle();
			
		 model.addAttribute("cycles",c);
		
		return "/admin/niveau/edit_niveau"; 
	}
	
	@RequestMapping("admin/niveau/update")
	public String updateNiveau(Niveau niveau) {
		
		Cycle c = iCycleService.rechercherCycleParId(niveau.getCycle().getId());
		
		iNiveauService.modifierNiveauParId(niveau.getId(), niveau.getLibelle(), c);
		
		return "redirect:/admin/niveau"; 
	} 
	    
	    

}
