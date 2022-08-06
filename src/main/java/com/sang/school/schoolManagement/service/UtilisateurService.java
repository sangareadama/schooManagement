package com.sang.school.schoolManagement.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sang.school.schoolManagement.dao.IUtilisateurDao;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.domain.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService {
	
	
	
	@Autowired
	private IUtilisateurDao iUtilisateurDao;
	
	@Autowired 
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	
	@Autowired
	 private IEleveService iEleveService;

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Utilisateur ut = new Utilisateur(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(),
				BCryptPasswordEncoder.encode(utilisateur.getPassword()),Arrays.asList(new Role("ROLE_ADMIN")));
		return iUtilisateurDao.save(ut); 
	}
 
	@Override
	public List<Utilisateur> listeUtilisateur() {
		// TODO Auto-generated method stub
		return iUtilisateurDao.listeUtilisateur();
	}

	@Override
	public Utilisateur ModifierUtilisateur(Long id, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur rechercherUtilisateurParEmail(String email) {
		// TODO Auto-generated method stub
		return iUtilisateurDao.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur ut = iUtilisateurDao.findByEmail(username);
		if(ut==null) {
			throw new UsernameNotFoundException("votre mot de passe ou email incorrect");
			 
		}
		return new org.springframework.security.core.userdetails.User(ut.getEmail(),ut.getPassword(),mapRolesAuthorities(ut.getRoles())) ;
	}
	
	private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getLibelle())).collect(Collectors.toList());
	} 

	@Override
	public void enregistrerUtilisateurAvecPhoto(String nom, String prenom, String email, String password,
			MultipartFile nomPhoto, Collection<Role> roles) {
		// TODO Auto-generated method stub
		    Utilisateur ut = new Utilisateur(); 
			
			/*
			 * Eleve eleveDefaut = iEleveService.rechercherEleveParId((long) 103); String
			 * PHOTODEFAUT= eleveDefaut.getPhoto();
			 */
			
			  String fileName = StringUtils.cleanPath(nomPhoto.getOriginalFilename());
			  if(fileName.contains("..")) { System.out.println("fichier nom valides"); }
			  try { if(fileName.isEmpty()) { //ut.setNomPhoto(PHOTODEFAUT); 
				  
			  } else {
			  ut.setNomPhoto(Base64.getEncoder().encodeToString(nomPhoto.getBytes())); }
			  
			  } catch (IOException e) { e.printStackTrace(); }
			 
			ut.setNom(nom); 
			ut.setPrenom(prenom);
			ut.setEmail(email);
			ut.setPassword(BCryptPasswordEncoder.encode(password));
			ut.setRoles(roles);
		    
		iUtilisateurDao.save(ut);
	}

}
