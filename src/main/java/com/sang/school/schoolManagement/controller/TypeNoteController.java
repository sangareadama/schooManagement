package com.sang.school.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.domain.TypeNote;
import com.sang.school.schoolManagement.service.ITypeNoteService;

@Controller
@RequestMapping("/")
public class TypeNoteController {
	
	@Autowired	
	ITypeNoteService iTypeNoteService;
	
	
	@RequestMapping({"admin/typeNote/list","admin/typeNote"})
	public String ListeTypeNote(Model model) {
			       	
		List<TypeNote> tn = iTypeNoteService.listeTypeNote();
		
		model.addAttribute("typeNote",tn);
		
		return "admin/typeNote/liste_typeNote";
	} 
	
	@RequestMapping("admin/typeNote/add")
	public String addTypeNote(Model model) {        
      
		model.addAttribute("typeNote", new TypeNote());
		
		return "/admin/typeNote/add_typeNote"; 
	}
	     
	@RequestMapping("admin/typeNote/save")
	public String SaveTypeNote(TypeNote typeNote) {
		
		iTypeNoteService.enregistrerTypeNote(typeNote);
		
		return "redirect:/admin/typeNote";
	}
	 
	@RequestMapping("admin/typeNote/delete")
	public String deleteTypeNote(Long  id) {

		iTypeNoteService.supprimerTypeNoteParId(id);
		
		return "redirect:/admin/typeNote";
	}
	
	@RequestMapping("admin/typeNote/edit")  
	public String editTypeNote(Model model ,Long id) {
		
		TypeNote tn = iTypeNoteService.rechercherTypeNoteParId(id);
		  
		model.addAttribute("typeNote", tn);
		
		return "/admin/typeNote/add_typeNote"; 
	}
	

}
