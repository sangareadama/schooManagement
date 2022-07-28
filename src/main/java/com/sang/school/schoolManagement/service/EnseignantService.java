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

import com.sang.school.schoolManagement.dao.IEnseignantDao;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Utilisateur;

@Service
public class EnseignantService implements IEnseignantService {

	@Autowired
	IEnseignantDao iEnseignantDao;
	
	@Autowired
	IEleveService iEleveService;
	
	@Transactional
	@Override
	public Enseignant enregistrerEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		return iEnseignantDao.save(enseignant);
	}

	@Override
	public List<Enseignant> listeEnseignant() {
		// TODO Auto-generated method stub
		return iEnseignantDao.findAll();
	}

	

	@Transactional
	@Override
	public void supprimerEnseignantParId(Long id) {
		// TODO Auto-generated method stub
		iEnseignantDao.deleteById(id);
	}

	@Override
	public Enseignant rechercherEnseignantParId(Long id) {
		// TODO Auto-generated method stub
		Optional<Enseignant> ens= iEnseignantDao.findById(id);
		
		return ens.get();
	}

	@Override
	public Enseignant enregistrerEnseignantAvecPhoto(String nom, String prenom, String email, 
			String telephone, String sexe, Date dateDeNaissance, String nationalite, String address,
			MultipartFile photo) {
		// TODO Auto-generated method stub
		
		Enseignant ens = new Enseignant();
		
		
		  //Eleve eleveDefaut = iEleveService.rechercherEleveParId((long) 103);
		  
		  //String PHOTODEFAUT= eleveDefaut.getPhoto(); 
		     
		
		  String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		  if(fileName.contains("..")) { System.out.println("fichier nom valides"); }
		  try { if(fileName.isEmpty()) { // ens.setPhoto(PHOTODEFAUT);
			  
		  } else { ens.setPhoto(Base64.getEncoder().encodeToString(photo.getBytes())); } } catch
		  (IOException e) { e.printStackTrace(); }  
		 
		ens.setNom(nom); 
		ens.setPrenom(prenom);
		ens.setEmail(email);
		ens.setTelephone(telephone); 
		ens.setSexe(sexe); 
		ens.setDateDeNaissance(dateDeNaissance);
		ens.setNationalite(nationalite);
		ens.setAddress(address); 
		
		return iEnseignantDao.save(ens);
	}

	@Override
	public Enseignant modifierEnseignant(Long id, String nom, String prenom, String email,
			String telephone, String sexe, Date dateDeNaissance, String nationalite, String address,
			MultipartFile photo) {
		Enseignant ens = rechercherEnseignantParId(id);
		
		
		  String oldPhoto = ens.getPhoto();
		  
		  String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		  if(fileName.contains("..")) { System.out.println("fichier nom valides"); }
		  try { if(fileName.isEmpty()) { ens.setPhoto(oldPhoto); } else {
		  ens.setPhoto(Base64.getEncoder().encodeToString(photo.getBytes())); } } catch
		  (IOException e) { e.printStackTrace(); }
		 
		ens.setNom(nom); 
		ens.setPrenom(prenom); 
		ens.setEmail(email);
		ens.setTelephone(telephone);
		ens.setSexe(sexe);
		ens.setDateDeNaissance(dateDeNaissance);
		ens.setNationalite(nationalite);
		ens.setAddress(address); 
		
		return iEnseignantDao.save(ens);
	}

	@Override
	public Enseignant rechercherEnseignantParEmail(String email) {
		// TODO Auto-generated method stub
		return iEnseignantDao.findByEmail(email);
	}

}
