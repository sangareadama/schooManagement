package com.sang.school.schoolManagement.service;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.dao.IEleveDao;
import com.sang.school.schoolManagement.domain.Eleve;

@Service
public class EleveService implements IEleveService {

	@Autowired
	private IEleveDao iEleveDao;
	
	@Autowired 
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	
	
	@Transactional
	@Override
	public Eleve enregistrerEleve(Eleve eleve) {
		
		
		iEleveDao.save(eleve);
		// TODO Auto-generated method stub
		return eleve;
	}

	@Override
	public List<Eleve> listeEleves() {
		  
		 return iEleveDao.listeEleve();
	}
 
	@Transactional
	@Override
	public void supprimerParId(Long id) {
		// TODO Auto-generated method stub
		iEleveDao.deleteById(id);
		
	}


	@Override
	public Eleve rechercherEleveParId(Long id) {
		// TODO Auto-generated method stub
		Optional<Eleve> el =	iEleveDao.findById(id);
		return el.get();
	}

	@Override
	public Eleve enregistrerEleveAvecPhoto(String nom, String prenom, String matricule,
			String sexe, String nationalite, String email, String password, String telephone, String address,
			Date dateDeNaissance, String classes, MultipartFile photo) {
		
		Eleve eleve = new Eleve();  
		
		//Eleve eleveDefaut = rechercherEleveParId((long) 103);
		
		//String PHOTODEFAUT= eleveDefaut.getPhoto();
		
		
		  String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		  if(fileName.contains("..")) { System.out.println("fichier nom valides"); }
		  try { if(fileName.isEmpty()) { //eleve.setPhoto(PHOTODEFAUT);
			  
		  } else {
		  eleve.setPhoto(Base64.getEncoder().encodeToString(photo.getBytes())); } }
		  catch (IOException e) { e.printStackTrace(); }
		 
		eleve.setNom(nom); 
		eleve.setPrenom(prenom);
		eleve.setEmail(email);
		eleve.setMatricule(matricule);
		eleve.setPassword(BCryptPasswordEncoder.encode(password));
		eleve.setTelephone(telephone);
		eleve.setSexe(sexe);
		eleve.setDateDeNaissance(dateDeNaissance);
		eleve.setNationalite(nationalite);
		eleve.setAddress(address);
		eleve.setClasses(classes);
		
		// TODO Auto-generated method stub
		return iEleveDao.save(eleve);
	}

	@Override
	public Eleve modifierEleve(Long id, String nom, String prenom, String matricule, String sexe,
			String nationalite, String email, String password, String telephone, String address, Date dateDeNaissance,
			String classes,MultipartFile photo) {
		
        Eleve eleve = rechercherEleveParId(id);
       
		
		
		  String oldPhoto = eleve.getPhoto();
		  
		  String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		  if(fileName.contains("..")) { System.out.println("fichier nom valides"); }
		  try { if(fileName.isEmpty()) { eleve.setPhoto(oldPhoto); } else {
		  eleve.setPhoto(Base64.getEncoder().encodeToString(photo.getBytes())); } }
		  catch (IOException e) { e.printStackTrace(); }
		  
		eleve.setNom(nom); 
		eleve.setPrenom(prenom);
		eleve.setEmail(email);
		eleve.setMatricule(matricule);
		eleve.setPassword(BCryptPasswordEncoder.encode(password));
		eleve.setTelephone(telephone);
		eleve.setSexe(sexe);
		eleve.setDateDeNaissance(dateDeNaissance);
		eleve.setNationalite(nationalite);
		eleve.setAddress(address);
		eleve.setClasses(classes);
		// TODO Auto-generated method stub
		return iEleveDao.save(eleve);
	}

	

}
