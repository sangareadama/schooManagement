package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.IniveauDao;
import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.domain.Niveau;

@Service
public class NiveauService implements INiveauService {
	
	@Autowired
	IniveauDao iNiveauDao;

	@Transactional
	@Override
	public Niveau enregistrerNiveau(String libelle, Cycle cycle) {
		// TODO Auto-generated method stub
		Niveau nv = new Niveau(libelle, cycle);
		
		return iNiveauDao.save(nv);
	}

	@Override
	public List<Niveau> listeNiveau() {
		// TODO Auto-generated method stub
		return iNiveauDao.listeNiveau();
	}

	@Transactional
	@Override
	public Niveau modifierNiveauParId(Long id, String libelle, Cycle cycle) {
		// TODO Auto-generated method stub
		Optional<Niveau> n = iNiveauDao.findById(id);
		
		n.get().setCycle(cycle);
		n.get().setLibelle(libelle);
		
		return iNiveauDao.save(n.get());
	}

	@Transactional
	@Override
	public void supprimerNiveauParId(Long id) {
		// TODO Auto-generated method stub
		iNiveauDao.deleteById(id);

	}

	@Override
	public Niveau rechercherNiveauParId(Long id) {
		// TODO Auto-generated method stub
		Optional<Niveau> n = iNiveauDao.findById(id);
		
		return n.get();
	}


	

}
