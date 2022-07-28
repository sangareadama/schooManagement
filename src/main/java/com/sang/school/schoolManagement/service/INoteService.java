package com.sang.school.schoolManagement.service;

import java.sql.Date;
import java.util.List;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Note;
import com.sang.school.schoolManagement.domain.TypeNote;

public interface INoteService {

	    public Note enregistrerNote(TypeNote typeNote, Cours matiere,Enseignant enseignant, Classe classe,Date dateNote, String heureDebut, String heureFin);
		
	    public List<Note> listeNote();
	    
	    public Note modifierNoteParId(Long id,TypeNote typeNote, Cours matiere,Enseignant enseignant,Classe classe, Date dateNote, String heureDebut, String heureFin);
	    
	    public void supprimerNoteParId(Long id);
	    
	    public Note rechercherNoteParId(Long id);
	    
	    public List<Note> findByEnseignantId(Long id);

}
