package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.embeddedId.EleveClasseId;

public interface EleveClasseDao extends JpaRepository<EleveClasse, EleveClasseId>{
	
   List<EleveClasse> findByEleveId(Long id);
   List<EleveClasse> findByClasseId(Long id);
}
