package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.IClasseDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Niveau;

@Service
public class ClasseService implements IClasseService {
	
	@Autowired
	IClasseDao iClasseDao;

	@Transactional
	@Override 
	public Classe enregistrerClasse(Niveau niveau, String designation) {
		// TODO Auto-generated method stub
		Classe cl = new Classe(niveau, designation);
				
		return iClasseDao.save(cl);
	}

	@Override
	public List<Classe> listeClasse() {
		// TODO Auto-generated method stub
		return iClasseDao.listeClasse();
	}

	@Transactional
	@Override
	public Classe modifierClasseParId(Long id, Niveau niveau, String designation) {
		// TODO Auto-generated method stub
		Optional<Classe> cl = iClasseDao.findById(id);
		
		cl.get().setNiveau(niveau);
		
		cl.get().setDesignation(designation);;
		
		iClasseDao.save(cl.get());
		
		return cl.get();
	}

	@Transactional
	@Override
	public void supprimerClasseParId(Long id) {
		// TODO Auto-generated method stub
		
		iClasseDao.deleteById(id);
	}

	@Override
	public Classe rechercherClasseParId(Long id) {
		
       Optional<Classe> cl = iClasseDao.findById(id);
		
		return cl.get();
	}

}
