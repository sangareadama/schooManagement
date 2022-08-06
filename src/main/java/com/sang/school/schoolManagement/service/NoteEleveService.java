package com.sang.school.schoolManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.INoteEleveDao;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.Note;
import com.sang.school.schoolManagement.domain.NoteEleve;
@Service
public class NoteEleveService implements INoteEleveService {
	
	@Autowired
	INoteEleveDao iNoteEleveDao;

	@Override
	public NoteEleve enregistrerNoteEleve(Note note, Eleve eleve, Double valeurNote) {
		// TODO Auto-generated method stub
		NoteEleve ne = new NoteEleve(note, eleve, valeurNote);
		
		return iNoteEleveDao.save(ne);
	} 
 
	@Override
	public List<NoteEleve> listeNoteEleve() {
		// TODO Auto-generated method stub
		return iNoteEleveDao.findAll();
	}

	@Override
	public NoteEleve modifierNoteEleveId(Long id, Double valeurNote) {
		
		NoteEleve ne = rechercherNoteEleveParId(id);
		
		ne.setNote(ne.getNote());
		ne.setEleve(ne.getEleve());
		ne.setValeurNote(valeurNote);
		// TODO Auto-generated method stub
		return iNoteEleveDao.save(ne);
	}

	@Override
	public void supprimerNoteEleveParId(Long id) {
		// TODO Auto-generated method stub
		
		iNoteEleveDao.deleteById(id);
	}

	@Override
	public NoteEleve rechercherNoteEleveParId(Long id) {
		// TODO Auto-generated method stub
		
		Optional<NoteEleve> ne = iNoteEleveDao.findById(id);
		
		return ne.get();
	}

	@Override
	public List<NoteEleve> findByNoteId(Long id) {
		// TODO Auto-generated method stub
		List<NoteEleve> nt=	iNoteEleveDao.findByNoteId(id);
		
		return nt;
		
	}
	
	


}
