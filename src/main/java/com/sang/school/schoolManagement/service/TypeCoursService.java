package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.ITypeCoursDao;
import com.sang.school.schoolManagement.domain.TypeCours;

@Service
public class TypeCoursService implements ITypeCoursService {
	
	@Autowired
	ITypeCoursDao iTypeCoursDao;

	
	@Override 
	public TypeCours enregistrerTypeCours(TypeCours typeCours) {
		// TODO Auto-generated method stub
		return iTypeCoursDao.save(typeCours);
	}

	@Override
	public List<TypeCours> listeTypeCours() {
		// TODO Auto-generated method stub
		return iTypeCoursDao.findAll();
	}

	
	@Override
	public TypeCours modifierTypeCoursParId(Long id, String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void supprimerTypeCoursParId(Long id) {
		// TODO Auto-generated method stub
		iTypeCoursDao.deleteById(id); 
	}

	@Override
	public TypeCours rechercherTypeCoursParId(Long id) {
		
			Optional<TypeCours> c = iTypeCoursDao.findById(id);
			 
			return c.get();
		}

}
