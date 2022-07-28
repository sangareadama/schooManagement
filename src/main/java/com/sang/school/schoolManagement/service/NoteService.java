package com.sang.school.schoolManagement.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.school.schoolManagement.dao.INoteDao;
import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Note;
import com.sang.school.schoolManagement.domain.TypeNote;

@Service
public class NoteService implements INoteService {

	@Autowired
	INoteDao iNoteDao;
	
	@Override
	public Note enregistrerNote(TypeNote typeNote, Cours matiere,Enseignant enseignant,Classe classe, Date dateNote, String heureDebut, String heureFin) {
		// TODO Auto-generated method stub
		
		Note note = new Note(typeNote, matiere,enseignant, classe, dateNote, heureDebut, heureFin);
		
		return iNoteDao.save(note); 
	}

	@Override
	public List<Note> listeNote() {
		// TODO Auto-generated method stub
		return iNoteDao.findAll();
	}

	@Override
	public Note modifierNoteParId(Long id,TypeNote typeNote, Cours matiere,Enseignant enseignant,Classe classe, Date dateNote, String heureDebut, String heureFin) {
		// TODO Auto-generated method stub
		Note note = rechercherNoteParId(id);
		note .setTypeNote(typeNote);
		note.setMatiere(matiere);
		note.setDateNote(dateNote);
		note.setEnseignant(enseignant);
		note.setHeureDebut(heureDebut);
		note.setHeureFin(heureFin);
		note.setClasse(classe);
		
		return iNoteDao.save(note);
	}

	@Override
	public void supprimerNoteParId(Long id) {
		// TODO Auto-generated method stub
		iNoteDao.deleteById(id);
	}

	@Override
	public Note rechercherNoteParId(Long id) {
		
		Optional<Note> note =iNoteDao.findById(id);
		
		return note.get();
	}

	@Override
	public List<Note> findByEnseignantId(Long id) {
		// TODO Auto-generated method stub
		return iNoteDao.findByEnseignantId(id);
	}

}
