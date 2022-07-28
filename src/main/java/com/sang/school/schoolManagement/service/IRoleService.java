package com.sang.school.schoolManagement.service;

import com.sang.school.schoolManagement.domain.Role;

import java.util.List;

public interface IRoleService {
	
	public Role rechercherRoleParLibelle(String libelle);
	
	public Role enregistrerRole(Role role);

	public List<Role> listeRole();



}
