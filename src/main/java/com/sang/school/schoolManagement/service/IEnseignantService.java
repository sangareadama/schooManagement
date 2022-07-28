package com.sang.school.schoolManagement.service;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.domain.Enseignant;

public interface IEnseignantService {
	
    public Enseignant enregistrerEnseignant(Enseignant enseignant);
    
    public Enseignant enregistrerEnseignantAvecPhoto(String nom, String prenom, String email, String telephone, String sexe,
			Date dateDeNaissance, String nationalite, String address,MultipartFile photo);
	
    public List<Enseignant> listeEnseignant();
    
    public Enseignant modifierEnseignant(Long id,String nom, String prenom, String email,
			String telephone, String sexe, Date dateDeNaissance, String nationalite, String address,
			MultipartFile photo);
    
    public void supprimerEnseignantParId(Long id);
    
    public Enseignant rechercherEnseignantParId(Long id);
    
    public Enseignant rechercherEnseignantParEmail(String email);

}
