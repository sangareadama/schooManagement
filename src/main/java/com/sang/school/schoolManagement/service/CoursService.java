package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.ICoursDao;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.TypeCours;

@Service
public class CoursService implements ICoursService {
	
	@Autowired
    ICoursDao iCoursDao;
	
	@Override
	public Cours enregistrerCours(String libelle,TypeCours typeCours) {
		// TODO Auto-generated method stub
		Cours cours = new Cours(libelle, typeCours);
		
		return iCoursDao.save(cours);
	}

	@Override 
	public List<Cours> listeCours() {
		// TODO Auto-generated method stub
		return iCoursDao.findAll();
	}

	@Override
	public Cours modifierCoursParId(Long id, String libelle,TypeCours typeCours) {
		// TODO Auto-generated method stub
		
		Cours c = rechercherCoursParId(id);
		
		c.setLibelle(libelle);
		
		c.setTypeCours(typeCours);
		
		return iCoursDao.save(c);
	}

	@Override
	public void supprimerCoursParId(Long id) {
		// TODO Auto-generated method stub
		iCoursDao.deleteById(id);
	}

	@Override
	public Cours rechercherCoursParId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cours> c = iCoursDao.findById(id);
		
		return c.get();
	}

}
