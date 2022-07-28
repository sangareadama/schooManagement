package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sang.school.schoolManagement.domain.Niveau;

public interface IniveauDao extends JpaRepository<Niveau, Long> {
	
	@Query("select n from Niveau n order by id asc")
	public List<Niveau> listeNiveau();

}
