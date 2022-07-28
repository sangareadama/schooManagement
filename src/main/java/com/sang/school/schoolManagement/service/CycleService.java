package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.ICycleDao;
import com.sang.school.schoolManagement.domain.Cycle;

@Service
public class CycleService implements ICycleService {
 
	@Autowired
	ICycleDao iCycleDao;
	
	@Transactional
	@Override
	public Cycle enregistrerCycle(Cycle cycle) {
		// TODO Auto-generated method stub
		return iCycleDao.save(cycle);
	}

	@Override
	public List<Cycle> listeCycle() {
		// TODO Auto-generated method stub
		return iCycleDao.findAll();
	}

	@Transactional
	@Override
	public Cycle modifierCycleParId(Long id, String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void supprimerCycleParId(Long id) {
		// TODO Auto-generated method stub
		iCycleDao.deleteById(id);
	}

	@Override
	public Cycle rechercherCycleParId(Long id) {
		// TODO Auto-generated method stub
		    Optional<Cycle> c = iCycleDao.findById(id);
		    
		return c.get();
	}

}
