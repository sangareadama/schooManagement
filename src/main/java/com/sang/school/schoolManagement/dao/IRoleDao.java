package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Role;

public interface IRoleDao extends JpaRepository<Role, Long>{
	
	Role findByLibelle(String libelle);

}
