package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sang.school.schoolManagement.domain.Utilisateur;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long>{

	@Query("select n from Utilisateur n order by id asc")
	public List<Utilisateur> listeUtilisateur();
	
	Utilisateur findByEmail(String email);
} 
