package com.sang.school.schoolManagement.controller.heroku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.dao.IGenreDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Genre;
import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.model.ModelEnseignantClasseCours;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.ICoursService;
import com.sang.school.schoolManagement.service.IEnseignantClasseCoursService;
import com.sang.school.schoolManagement.service.IEnseignantService;
import com.sang.school.schoolManagement.service.IRoleService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("/")
public class EnseignantController {
	
	@Autowired
	IEnseignantService iEnseignantService;
	
	@Autowired
	ICoursService iCoursService;
	
	@Autowired
	IClasseService iClasseService;
	
	@Autowired
	 private IRoleService iRoleService;
	
	@Autowired
	private IUtilisateurService iUtilisateurService;
	
	@Autowired 
	IGenreDao iGenreDao;
	
	@Autowired
	IEnseignantClasseCoursService  iEnseignantClasseCoursService;
	
	@RequestMapping({"admin/enseignant/list","admin/enseignant"})
	public String ListeEnseignant(Model model) { 
		
		List<Enseignant> ens = iEnseignantService.listeEnseignant();
				
		model.addAttribute("enseignants",ens); 
		
		return "admin/enseignant/liste_enseignant";
	}


	@RequestMapping("admin/enseignant/add")
	public String addEnseignant(Model model) {
		
		List <Genre> genre = lesGenres();
		
		model.addAttribute("enseignant", new Enseignant());
		
		model.addAttribute("genre",genre);
		 
		return "admin/enseignant/add_enseignant";
	}
	
	public List <Genre> lesGenres() {
		
		List <Genre> sexes = iGenreDao.findAll();
		if(sexes.isEmpty()) {
			
			iGenreDao.save(new Genre("Masculin"));
			
			iGenreDao.save(new Genre("Feminin"));
		}	
		
		return  iGenreDao.findAll();		
	}
	
	@RequestMapping("admin/enseignant/save")
	public String saveEnseignant(@RequestParam("file") MultipartFile file,Enseignant enseignant) {
		
		//enregistrer eleve comme utilisateurs
		 
		 String Password=enseignant.getNom().substring(0, 3)+enseignant.getTelephone().substring(7, 10);
		 
		 Role role = iRoleService.rechercherRoleParLibelle("ROLE_ENSEIGNANT");
		 
		 iUtilisateurService.enregistrerUtilisateurAvecPhoto(enseignant.getNom(),
				enseignant.getPrenom(),enseignant.getEmail(),Password, file,Arrays.asList(role));
		
		iEnseignantService.enregistrerEnseignantAvecPhoto(enseignant.getNom(),enseignant.getPrenom(),enseignant.getEmail(),
				enseignant.getTelephone(),enseignant.getSexe(),enseignant.getDateDeNaissance(),
				enseignant.getNationalite(),enseignant.getAddress(),file);
	
		
		return "redirect:/admin/enseignant"; 
	} 
	
	@RequestMapping("admin/enseignant/delete")
	public String deleteEnseignant(Long  id) {
		
		iEnseignantService.supprimerEnseignantParId(id);
		
		return "redirect:/admin/enseignant";
	}
	
	@RequestMapping("admin/enseignant/edit")
	public String editEnseignant(Model model ,Long id) {
		
				
	 	Enseignant ens = iEnseignantService.rechercherEnseignantParId(id);
	 	
	 	List <Genre> genre = iGenreDao.findAll();
		
		model.addAttribute("genre",genre);
		
		model.addAttribute("enseignant", ens);
		 
		return "/admin/enseignant/edit_enseignant"; 
	}
	
	@RequestMapping("admin/enseignant/update")
	//public String updateEleve(@RequestParam("classeListe") List<Classe> classeListe,Eleve eleve) {
	    public String updateEnseignant(@RequestParam("file") MultipartFile file,Enseignant enseignant) {
		
		iEnseignantService.modifierEnseignant(enseignant.getId(), enseignant.getNom(), enseignant.getPrenom(),
				enseignant.getEmail(), enseignant.getTelephone(), enseignant.getSexe(), 
				enseignant.getDateDeNaissance(), enseignant.getNationalite(), enseignant.getAddress(),file);
		
		return "redirect:/admin/enseignant";
		
	}
	
	
	@RequestMapping("admin/enseignant/add_formation")
	public String add_formation(Model model ,Long id) {
		
		Enseignant ens = iEnseignantService.rechercherEnseignantParId(id);
		
		List<Classe> cl = iClasseService.listeClasse();
		model.addAttribute("enseignant", ens);
		
		model.addAttribute("classes", cl);
		
       List<Cours> c = iCoursService.listeCours();
		
		model.addAttribute("cours", c);
		
		
		return "/admin/enseignant/add_formation"; 
	}
	
	@RequestMapping("admin/enseignant/save_formation")
	public String save_formation(ModelEnseignantClasseCours MECC) {
		
		Enseignant ens = iEnseignantService.rechercherEnseignantParId(MECC.getEnseignantId());
		
		Classe cl = iClasseService.rechercherClasseParId(MECC.getClasseId());
		
		Cours cr = iCoursService.rechercherCoursParId(MECC.getCoursId());
		
		iEnseignantClasseCoursService.enregistrerEnseignantClasseCours(ens, cl, cr);
		    
		return "redirect:/admin/enseignant"; 
	}

}
