package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Utilisateur;

public interface IEnseignantDao extends JpaRepository<Enseignant, Long> {
	
	Enseignant findByEmail(String email);
}
