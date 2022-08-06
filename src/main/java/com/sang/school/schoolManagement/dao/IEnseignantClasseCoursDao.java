package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.EnseignantClasseCours;
import com.sang.school.schoolManagement.embeddedId.EnseignantClasseCoursId;

public interface IEnseignantClasseCoursDao extends JpaRepository<EnseignantClasseCours, EnseignantClasseCoursId>{

	List<EnseignantClasseCours> findByEnseignantId(Long id);
	
	List<EnseignantClasseCours> findByClasseId(Long id); 
}
