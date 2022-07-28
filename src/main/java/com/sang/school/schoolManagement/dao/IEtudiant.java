package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sang.school.schoolManagement.domain.Eleve;

@RepositoryRestResource
public interface IEtudiant extends JpaRepository<Eleve, Long> {
	
	/*
	 * @Query("select p from Eleve p") public List<Eleve> liste();
	 */

}
