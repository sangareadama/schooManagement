package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.ITypeNoteDao;
import com.sang.school.schoolManagement.domain.TypeNote;

@Service
public class TypeNoteService implements ITypeNoteService {
	
	@Autowired
	ITypeNoteDao iTypeNoteDao;

	@Override
	public TypeNote enregistrerTypeNote(TypeNote typeNote) {
		// TODO Auto-generated method stub
		return iTypeNoteDao.save(typeNote);
	}

	@Override
	public List<TypeNote> listeTypeNote() {
		// TODO Auto-generated method stub
		return iTypeNoteDao.findAll();
	}

	@Override
	public TypeNote modifierTypeNoteParId(Long id, String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerTypeNoteParId(Long id) {
		// TODO Auto-generated method stub
		iTypeNoteDao.deleteById(id);
	}

	@Override
	public TypeNote rechercherTypeNoteParId(Long id) {
		// TODO Auto-generated method stub
		Optional<TypeNote> tn = iTypeNoteDao.findById(id);
		
		return tn.get();
	}

	
	
	
}
