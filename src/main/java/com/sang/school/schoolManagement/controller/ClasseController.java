package com.sang.school.schoolManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.EnseignantClasseCours;
import com.sang.school.schoolManagement.domain.Niveau;
import com.sang.school.schoolManagement.domain.Utilisateur;
import com.sang.school.schoolManagement.model.ModelClasse;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.IEleveClasseService;
import com.sang.school.schoolManagement.service.IEnseignantClasseCoursService;
import com.sang.school.schoolManagement.service.IEnseignantService;
import com.sang.school.schoolManagement.service.INiveauService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("/")
public class ClasseController {
	
	@Autowired
	IClasseService iClasseService;
	
	@Autowired
	INiveauService iNiveauService;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@Autowired
	IEnseignantService iEnseignantService;
	
	@Autowired
	IEleveClasseService IEleveClasseService;
	
	@Autowired
	IEnseignantClasseCoursService iEnseignantClasseCoursService;
	
	/*
	 * @RequestMapping(value="/listeClasse",method=RequestMethod.GET) public
	 * List<Classe> listeClasse() {
	 * 
	 * return iClasseService.listeClasse(); }
	 * 
	 * @RequestMapping(value="/enregistrerClasse",method=RequestMethod.POST) public
	 * Object enregistrerClasse(@RequestBody ModelClasse n) throws IOException{
	 * 
	 * Niveau nv = INiveauService.rechercherNiveauParId(n.getNiveauId());
	 * 
	 * return iClasseService.enregistrerClasse(nv, n.getDesignation());
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/supprimerClasse",method=RequestMethod.POST) public
	 * void supprimerClasse(@RequestBody Classe n) throws IOException{
	 * 
	 * 
	 * iClasseService.supprimerClasseParId(n.getId());
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(value="/modifierClasse",method=RequestMethod.POST) public
	 * Object modifierClasse(@RequestBody ModelClasse n) throws IOException{
	 * 
	 * Niveau nv = INiveauService.rechercherNiveauParId(n.getNiveauId());
	 * 
	 * return iClasseService.modifierClasseParId(n.getId(), nv, n.getDesignation());
	 * 
	 * }
	 */
	
	@RequestMapping("admin/classe/add")
	public String addClasse(Model model) {
		
		model.addAttribute("classe", new ModelClasse());
		 
        List<Niveau> niv = iNiveauService.listeNiveau();
		
		model.addAttribute("niveaux",niv);
		
		return "admin/classe/add_classe";
	}
	
	@RequestMapping({"admin/classe/list","admin/classe"})
	public String ListeClasse(Model model) { 
		
		List<Classe> cl = iClasseService.listeClasse();     
		
		model.addAttribute("classes",cl);  
		
		return "admin/classe/liste_classe";
	} 
	
	@RequestMapping("admin/classe/save")
	public String saveClasse(ModelClasse modelClasse) {
		
		Niveau nv = iNiveauService.rechercherNiveauParId(modelClasse.getNiveauId());
		
		iClasseService.enregistrerClasse(nv, modelClasse.getDesignation());
		
		return "redirect:/admin/classe";
	} 
	
	@RequestMapping("admin/classe/delete")
	public String deleteClasse(Long  id) {
		
		iClasseService.supprimerClasseParId(id);
		
		return "redirect:/admin/classe";
	}
	
	@RequestMapping("admin/classe/edit")
	public String editClasse(Model model ,Long id) {
		
		Classe cl = iClasseService.rechercherClasseParId(id);
		
		List<Niveau> niv = iNiveauService.listeNiveau();
			
	    model.addAttribute("niveaux",niv);
		
		model.addAttribute("classe", cl);
		
		return "admin/classe/edit_classe"; 
	}
	
	@RequestMapping("admin/classe/update")
	public String updateClasse(Classe classe) {
		
		Niveau nv = iNiveauService.rechercherNiveauParId(classe.getNiveau().getId());
		
		iClasseService.modifierClasseParId(classe.getId(), nv, classe.getDesignation());
		
		return "redirect:/admin/classe"; 
	} 
	
	// recuperer la liste des enseignantClasseCours de l'enseignant connecté
	public List<EnseignantClasseCours>ListeEnseignantClasseCours(){
		   
		   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String user=auth.getName();
		    Utilisateur ut= utilisateurService.rechercherUtilisateurParEmail(user);
		    
		    Enseignant ens = iEnseignantService.rechercherEnseignantParEmail(ut.getEmail());
		    
		    List <EnseignantClasseCours> ecc= iEnseignantClasseCoursService.findByEnseignantId(ens.getId());
		 
		 return ecc;   
	   }
	
	//la listes des cours faite par l'enseignant conecter dans une classe
	public List<Cours> ListeDesCoursDeLEnseignantDeLaClase(Classe cl){
		
		List <EnseignantClasseCours> ecc= ListeEnseignantClasseCours();
		
        List<Cours> coursDEnseignant = new ArrayList<Cours>();
	    
	    for (EnseignantClasseCours enseignantClasseCours : ecc) {
	    	
	    	if(enseignantClasseCours.getClasse().equals(cl)){
	    		
	    		coursDEnseignant.add(enseignantClasseCours.getCours());
	    	}   	 
			
		}
		
		return coursDEnseignant;		
	}
	
	//la liste des eleeves de la classe en parametre
	public List<Eleve> ListeEleveParClasse(Classe cl){
		
        List<EleveClasse> eleveClasse= IEleveClasseService.findByClasseId(cl.getId());
		
		List<Eleve> eleves = new ArrayList<Eleve>();
		
		for (EleveClasse eleveCl : eleveClasse) {
			
			eleves.add(eleveCl.getEleve());
			
		}
		
		return eleves;
	}

	@RequestMapping({"enseignant/classes/list","enseignant/classes"})
	public String ListeClasses(Model model) { 
	    
	    List <EnseignantClasseCours> ecc= ListeEnseignantClasseCours();
	    
	    HashSet<Classe> classesDEnseignant = new HashSet<Classe>();
	    
	    for (EnseignantClasseCours enseignantClasseCours : ecc) {
	    	 
	      classesDEnseignant.add(enseignantClasseCours.getClasse());   	
			
		}
	    
	    HashSet<Integer>  j = new HashSet<Integer>();
	    
		List<Classe> cl = iClasseService.listeClasse();     
		
		model.addAttribute("classes",classesDEnseignant);  
		 
		return "adminEnseignant/classe/liste_classe";
	} 
	
	@RequestMapping("enseignant/classe/addNotes")
	public String addNotes(Model model ,Long id) {
		
		Classe cl = iClasseService.rechercherClasseParId(id);
		
		List<Cours> cours = ListeDesCoursDeLEnseignantDeLaClase(cl);
		
		List<Eleve> eleves = ListeEleveParClasse(cl);
		
		model.addAttribute("cours",cours);
		
		model.addAttribute("eleves",eleves);
			
		
		for (Eleve cr : eleves) {
			
			System.out.println(";;;;;;;;;;;;;;;;"+cr.getNom());
		}
		
	   // model.addAttribute("cours",cours);
		
		return "adminEnseignant/note/add_notes";
	}
	
}
