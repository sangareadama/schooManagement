package com.sang.school.schoolManagement.controller.heroku;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.model.ModelEleves;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.ICoursService;
import com.sang.school.schoolManagement.service.IEleveService;

@RestController
public class RestAPIController {
	
	@Autowired
	IEleveService iEleveService;
	
	@Autowired
	IClasseService iClasseService;
	
	@Autowired
	ICoursService iCoursService;
	
	 @RequestMapping(value="/eleve",method=RequestMethod.GET) public List<Eleve>
	  ListeEleve() {
	  
	  return iEleveService.listeEleves(); }
	  
	  @RequestMapping(value="/enregistrerEleve",method=RequestMethod.POST) public
	  Object enregistrerCycle(@RequestBody ModelEleves m) throws IOException{
		  
	  return m; 
	  
	  }
	  
	  @RequestMapping(value="/listeClasse",method=RequestMethod.GET) public
	   List<Classe> listeClasse() {
	
	   return iClasseService.listeClasse(); }
	  
	  @RequestMapping(value="/listeCours",method=RequestMethod.GET) public
	   List<Cours> listeCours() {
	
	   return iCoursService.listeCours(); }

}
