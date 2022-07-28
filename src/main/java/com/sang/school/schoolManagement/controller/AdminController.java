package com.sang.school.schoolManagement.controller;

import java.util.Arrays;
import java.util.List;

import com.sang.school.schoolManagement.domain.Cycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.dao.EleveClasseDao;
import com.sang.school.schoolManagement.dao.IUtilisateurDao;
import com.sang.school.schoolManagement.dao.IniveauDao;
import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.domain.Utilisateur;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.ICoursService;
import com.sang.school.schoolManagement.service.IEleveClasseService;
import com.sang.school.schoolManagement.service.IEleveService;
import com.sang.school.schoolManagement.service.IEnseignantClasseCoursService;
import com.sang.school.schoolManagement.service.IEnseignantService;
import com.sang.school.schoolManagement.service.INiveauService;
import com.sang.school.schoolManagement.service.IRoleService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("/admin")
public class AdminController{
	
	@Autowired
	IUtilisateurService iUtilisateurService;
	
	@Autowired
	private IUtilisateurDao iUtilisateurDao;
	
	@Autowired
	 private IRoleService iRoleService;
	
	@Autowired
	INiveauService iNiveauService;
	
	@Autowired
	IniveauDao iNiveauDao;
	
	@Autowired
	IClasseService iClasseService;
	
	
	@Autowired
	IEleveService iEleveService;
	
	@Autowired
	IEleveClasseService IEleveClasseService;
	
	@Autowired
	EleveClasseDao eleveClasseDao;
	
	@Autowired
	IEnseignantService iEnseignantService;
	
	@Autowired
	ICoursService iCoursService;
	
	@Autowired
	IEnseignantClasseCoursService  iEnseignantClasseCoursService;
	
	
	@RequestMapping({"/dashboard","/"})
	public String dashboardPage() {
		return "admin/dashboard";
	} 
	
	@RequestMapping("/user/add")
	public String addUser(Model model) {
		
		model.addAttribute("utilisateur", new Utilisateur());

		return "admin/user_add";
	}
	
	@RequestMapping({"/user/list","/user"})
	public String ListeUser(Model model) {
		List<Utilisateur> ut = iUtilisateurService.listeUtilisateur();
		model.addAttribute("utilisateur",ut);
		return "admin/User_list";
	} 
	
	@RequestMapping("/user/save") 
	public String saveUser(@RequestParam("file") MultipartFile file,Utilisateur utilisateur) {
		
	    Role role = iRoleService.rechercherRoleParLibelle("ROLE_ADMIN");
	  
		iUtilisateurService.enregistrerUtilisateurAvecPhoto(utilisateur.getNom(), utilisateur.getPrenom()
		, utilisateur.getEmail(), utilisateur.getPassword(), file,Arrays.asList(role));
		
		return "redirect:/admin/user/list";
	}

	@RequestMapping("/user/role/add")
	public String addRole(Model model) {

		model.addAttribute("role", new Role());

		return "admin/user_addRole";
	}

	@RequestMapping("/user/role/save")
	public String SaveCycle(Role role) {

		iRoleService.enregistrerRole(role);

		return "redirect:/admin/user/role/list";
	}


	@RequestMapping({"/user/role/list"})
	public String ListeRole(Model model) {
		List<Role> roles = iRoleService.listeRole();
		model.addAttribute("roles",roles);
		return "admin/role_list";
	}

	@RequestMapping("/user/delete")
	public String deleteUser(Long id) {
		
		iUtilisateurDao.deleteById(id);
		
		return "redirect:/admin/user/list";
	} 
	
	
}