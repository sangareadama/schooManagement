package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sang.school.schoolManagement.domain.Classe;

public interface IClasseDao  extends JpaRepository<Classe, Long>{
	
	@Query("select n from Classe n order by id asc")
	public List<Classe> listeClasse();


}
