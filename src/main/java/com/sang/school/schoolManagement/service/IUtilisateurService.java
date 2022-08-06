package com.sang.school.schoolManagement.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.domain.Utilisateur;

public interface IUtilisateurService  extends UserDetailsService{
	
	
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur);
	
    public void enregistrerUtilisateurAvecPhoto(String nom, String prenom, String email, String password,MultipartFile nomPhoto,
			Collection<Role> roles);
    public List<Utilisateur> listeUtilisateur();
    
    public Utilisateur ModifierUtilisateur(Long id ,Utilisateur utilisateur);
    
    public Utilisateur rechercherUtilisateurParEmail(String email);

}
