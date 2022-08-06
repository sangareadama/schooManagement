package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sang.school.schoolManagement.domain.Eleve;

@Primary
public interface IEleveDao  extends JpaRepository<Eleve, Long>{
	
	@Query("select p from Eleve p order by id asc")
	public  List<Eleve> listeEleve();

}
