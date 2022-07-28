package com.sang.school.schoolManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.IEnseignantClasseCoursDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.EnseignantClasseCours;
import com.sang.school.schoolManagement.embeddedId.EnseignantClasseCoursId;

@Service
public class EnseignantClasseCoursService implements IEnseignantClasseCoursService {

	@Autowired
	IEnseignantClasseCoursDao iEnseignantClasseCoursDao;
	
	@Transactional
	@Override
	public EnseignantClasseCours enregistrerEnseignantClasseCours(Enseignant enseignant, Classe classe, Cours cours) {
		// TODO Auto-generated method stub
		EnseignantClasseCours  E = new EnseignantClasseCours(enseignant, classe, cours);
		
		return iEnseignantClasseCoursDao.save(E);
	}

	@Override
	public EnseignantClasseCours modifierEnseignantClasseCours(EnseignantClasseCoursId id, Enseignant enseignant,
			Classe classe, Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupprimerEnseignantClasseCoursParid(EnseignantClasseCours enseignantClasseCours) {
		// TODO Auto-generated method stub
		iEnseignantClasseCoursDao.delete(enseignantClasseCours);
	}

	@Override
	public List<EnseignantClasseCours> findByEnseignantId(Long id) {
		// TODO Auto-generated method stub
		
		return iEnseignantClasseCoursDao.findByEnseignantId(id);
	}

	@Override
	public List<EnseignantClasseCours> findByClasseId(Long id) {
		// TODO Auto-generated method stub
		return iEnseignantClasseCoursDao.findByClasseId(id);
	}

}
