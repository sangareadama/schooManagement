package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.EleveClasseDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.embeddedId.EleveClasseId;


@Service
public class EleveClasseService implements IEleveClasseService {

	
	@Autowired
	EleveClasseDao eleveClasseDao;
	
	@Override
	public EleveClasse enregistrerEleveClasse(Eleve eleve, Classe classe) {
		// TODO Auto-generated method stub
		EleveClasse ec = new EleveClasse(eleve, classe);
		
		return eleveClasseDao.save(ec);
	}

	@Override
	public EleveClasse modifierEleveClasse(EleveClasseId id, Eleve eleve, Classe classe) {
		// TODO Auto-generated method stub
		
		Optional<EleveClasse> ec = eleveClasseDao.findById(id);
		
		return eleveClasseDao.save(ec.get());
	}

	@Override
	public void SupprimerEleveClasseParid(EleveClasse eleveClasse) {
		// TODO Auto-generated method stub
		eleveClasseDao.delete(eleveClasse);
	}

	@Override
	public List<EleveClasse> findByEleveId(Long id) {
		// TODO Auto-generated method stub
		return eleveClasseDao.findByEleveId(id);
	}
 
	@Override
	public List<EleveClasse> findByClasseId(Long id) {
		// TODO Auto-generated method stub
		return eleveClasseDao.findByClasseId(id);
	}

}
