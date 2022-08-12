package com.sang.school.schoolManagement.controller.heroku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.dao.EleveClasseDao;
import com.sang.school.schoolManagement.dao.IGenreDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.domain.Genre;
import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.model.LotNote;
import com.sang.school.schoolManagement.model.ModelAs;
import com.sang.school.schoolManagement.model.ModelEleves;
import com.sang.school.schoolManagement.model.ModelNoteEleve;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.IEleveClasseService;
import com.sang.school.schoolManagement.service.IEleveService;
import com.sang.school.schoolManagement.service.IRoleService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("/")
public class EleveController {
	 
	@Autowired
	IEleveService iEleveService;
	
	@Autowired
	IEleveClasseService IEleveClasseService;
	
	@Autowired
	EleveClasseDao eleveClasseDao;
	
	@Autowired
	IClasseService iClasseService;
	
	@Autowired 
	IGenreDao iGenreDao;
	
	@Autowired
	 private IRoleService iRoleService;
	
	@Autowired
	private IUtilisateurService iUtilisateurService;
	
	List<Eleve> ListeEleveEnVu = new ArrayList<Eleve>();
	
	 /*  
	  @RequestMapping(value="/eleve",method=RequestMethod.GET) public List<Eleve>
	  ListeEleve() {
	  
	  return iEleveService.listeEleves(); }
	  
	  @RequestMapping(value="/enregistrerEleve",method=RequestMethod.POST) public
	  Object enregistrerCycle(@RequestBody ModelEleves m) throws IOException{
		  
	  return m;
	  

	  }
	 
	  //
	  
	  
	  }
	  
	  @RequestMapping(value="/suprimerEleve",method=RequestMethod.POST) public void
	  suprimerEleve(@RequestBody Eleve m) throws IOException{
	  
	  
	  iEleveService.supprimerParId(m.getId());
	  
	  }
	  
	  
	  @RequestMapping(value="/modifierEleve",method=RequestMethod.POST) public
	  Object modifierEleve(@RequestParam("eleve") String donnee) throws
	  IOException{
	  
	  ModelEleves m = new ObjectMapper().readValue(donnee, ModelEleves.class);
	  return m;
	  
	  
	  // return iEleveService.modifierEleve(m.getId(),m.getNom(), m.getPrenom());
	  
	  } 
	  */	
	
	@RequestMapping({"admin/eleve/list","admin/eleve"})
	public String ListeEleve(Model model) {   
		
		/*
		 * List<Map<String,Object>>results = new ArrayList<Map<String,Object>>();
		 * List<Eleve> el = iEleveService.listeEleves(); for (Eleve eleve : el) {
		 * List<EleveClasse> cl = IEleveClasseService.findByEleveId(eleve.getId());
		 * Map<String,Object>c = new HashMap<String,Object>(); c.put("el", el);
		 * c.put("cl", cl); results.add(c);
		 * 
		 * }
		 */			
		
		List<Eleve> el = iEleveService.listeEleves();
	   
		model.addAttribute("eleves",el); 
		
		ListeEleveEnVu.addAll(el);
		
		model.addAttribute("noteEleve",new ModelNoteEleve());
		 
		return "admin/eleve/liste_eleve";
	}
	
	@RequestMapping("admin/eleve/add")
	public String addEleve(Model model) {
		
		List <Genre> genre = lesGenres();
		
		model.addAttribute("genre",genre);
		
		model.addAttribute("eleve", new ModelAs());
		
		List<Classe> c = iClasseService.listeClasse();
		
		model.addAttribute("classes",c);
		 
		return "admin/eleve/add_eleve";
	}
	
	@RequestMapping("admin/eleve/save")  
	public String saveEleve(@RequestParam("file") MultipartFile file, ModelAs eleve) { 
	
		
		  //rechercher la classe 
		Classe cl = iClasseService.rechercherClasseParId(eleve.getClasseId()); 
		String classe = cl.getNiveau().getLibelle()+" - "+cl.getDesignation();
		  
		  //enregistrer eleve comme utilisateurs
		  
		  String Email=eleve.getNom()+eleve.getPrenom()+genererInt(1000,9999);
		  
		  String Password=eleve.getNom().substring(0,
		  3)+eleve.getMatricule().substring(0, 3);
		  
		  Role role = iRoleService.rechercherRoleParLibelle("ROLE_ELEVE");
		  
		  iUtilisateurService.enregistrerUtilisateurAvecPhoto(eleve.getNom(),
		  eleve.getPrenom(),Email ,Password, file,Arrays.asList(role));
		  
		  //enregistrer eleve 
          Eleve el = iEleveService.enregistrerEleveAvecPhoto(eleve.getNom(), eleve.getPrenom(),
		  eleve.getMatricule(), eleve.getSexe(), eleve.getNationalite(),
		  Email.toLowerCase(), Password, eleve.getTelephone(), eleve.getAddress(),
		  eleve.getDateDeNaissance(), classe, file);
		  
		  
		  // trouver la classe et l'enregistrer avec l"eleve
		  
		  IEleveClasseService.enregistrerEleveClasse(el, cl);
		 
		
			
		return "redirect:/admin/eleve";
	} 
	
	public int genererInt(int borneInf, int borneSup){
		   Random random = new Random();
		   int nb; 
		   nb = borneInf+random.nextInt(borneSup-borneInf);
		   return nb;
		}
	
    public List <Genre> lesGenres() {
		
		List <Genre> sexes = iGenreDao.findAll();
		if(sexes.isEmpty()) {
			
			iGenreDao.save(new Genre("Masculin"));
			
			iGenreDao.save(new Genre("Feminin"));
		}	
		
		return  iGenreDao.findAll();		
	}
	
	@RequestMapping("admin/eleve/delete")
	public String deleteEleve(Long  id) { 
		
		List<EleveClasse> ec = IEleveClasseService.findByEleveId(id);
		
		for (EleveClasse eleveClasse : ec) {  
			
			IEleveClasseService.SupprimerEleveClasseParid(eleveClasse);
		}
		
		iEleveService.supprimerParId(id);		 
		
		return "redirect:/admin/eleve";
	}
	
	@RequestMapping("admin/eleve/edit")
	public String editEleve(Model model ,Long id) {
		
		Eleve el = iEleveService.rechercherEleveParId(id);
		
	    model.addAttribute("eleve",el);
	    
        List <Genre> genre = iGenreDao.findAll();
		
		model.addAttribute("genre",genre);
	    
        List<Classe> cl = iClasseService.listeClasse();
		
		model.addAttribute("classes",cl);
		
		
		return "admin/eleve/edit_eleve"; 
	}
	
	@RequestMapping("admin/eleve/update")
	//public String updateEleve(@RequestParam("classeListe") List<Classe> classeListe,Eleve eleve) {
	public String updateEleve(@RequestParam("file") MultipartFile file,ModelAs eleve) {
		List<EleveClasse> ec = IEleveClasseService.findByEleveId(eleve.getId());
		
		//iEleveService.modifierEleve(eleve.getId(), eleve.getNom(), eleve.getPrenom(),eleve.getMatricule(),eleve.getDateNaissance());
		
		/*
		 * for (EleveClasse eleveClasse : ec) {
		 * 
		 * IEleveClasseService.SupprimerEleveClasseParid(eleveClasse); for (Classe cl :
		 * classeListe) {
		 * 
		 * IEleveClasseService.enregistrerEleveClasse(eleve, cl);
		 * 
		 * }
		 * 
		 * }
		 */
		
		Classe cl = iClasseService.rechercherClasseParId(eleve.getClasseId());
		
		 String classe = cl.getNiveau().getLibelle()+" - "+cl.getDesignation();
		
		iEleveService.modifierEleve(eleve.getId(),eleve.getNom(), eleve.getPrenom(), eleve.getMatricule(),
				 eleve.getSexe(), eleve.getNationalite(), eleve.getEmail(), "eleve",
				 eleve.getTelephone(), eleve.getAddress(), eleve.getDateDeNaissance(), classe, file);
		
		return "redirect:/admin/eleve";
	} 
	
	@RequestMapping("/admin/eleve/addToClass")
	public String addToClass(Model model,Long id) {
		
		Eleve el = iEleveService.rechercherEleveParId(id);
		
		List<Classe> classe = iClasseService.listeClasse();
		
		model.addAttribute("classes",classe);
		
		model.addAttribute("eleve",el);
		
		return "admin/eleve/add_to_classe";
	}
	
	@RequestMapping("/admin/eleve/saveToClass")
	public String saveToClass(@RequestParam("classeId") long classeId,Eleve eleve) {
		
		 Eleve el = iEleveService.rechercherEleveParId(eleve.getId());
		 
		 Classe cl = iClasseService.rechercherClasseParId(classeId);
		
		 String classe = el.getClasses()+ " et "+ cl.getNiveau().getLibelle()+" - "+cl.getDesignation();
		 
		// iEleveService.modifierEleve(eleve.getId(), el.getNom(), el.getPrenom(), el.getMatricule(), 
			//	 el.getDateNaissance(),classe); 
		
		 IEleveClasseService.enregistrerEleveClasse(el, cl);
		
		return "redirect:/admin/eleve";
	}
	
	
	@RequestMapping("admin/typeNote/prof")  
	public String editProf( @RequestParam("noteListe") List<Double> noteListe, ModelNoteEleve noteEleve) {
		
	  
		
		List<Eleve> Eleves= ListeEleveEnVu; 
		
		for (int i = 0; i < noteListe.size(); i++) {
			
			System.out.println(";;;;;;;;;;;;;;;;Eleve"+Eleves.get(i).getNom());
			
			System.out.println(";;;;;;;;;;;;;;;;note"+noteListe.get(i));
			
		}
		
      
		return null;    
	}
	
	
	
    
}
