package com.sang.school.schoolManagement.service;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.domain.Eleve;

public interface IEleveService {
	
	public Eleve enregistrerEleve(Eleve eleve);
	
	public Eleve enregistrerEleveAvecPhoto(String nom, String prenom, String matricule, String sexe, String nationalite,
			String email, String password, String telephone, String address, Date dateDeNaissance, String classes,
			MultipartFile photo);
	
    public List<Eleve> listeEleves();
    
    public Eleve modifierEleve(Long id, String nom, String prenom, String matricule, String sexe, String nationalite,
			String email, String password, String telephone, String address, Date dateDeNaissance, String classes,
			MultipartFile photo);
    
    public void supprimerParId(Long id);
    
    public Eleve rechercherEleveParId(Long id);

}
