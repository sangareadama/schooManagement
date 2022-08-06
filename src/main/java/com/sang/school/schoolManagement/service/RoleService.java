package com.sang.school.schoolManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.IRoleDao;
import com.sang.school.schoolManagement.domain.Role;

import java.util.List;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	IRoleDao iRoleDao;

	@Override
	public Role rechercherRoleParLibelle(String libelle) {
		
		return iRoleDao.findByLibelle(libelle);
	}

	@Override
	public Role enregistrerRole(Role role) {
		// TODO Auto-generated method stub
		return iRoleDao.save(role);
	}

	@Override
	public List<Role> listeRole() {
		return iRoleDao.findAll();
	}


}
