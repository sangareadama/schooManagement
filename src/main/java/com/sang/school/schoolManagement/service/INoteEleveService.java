package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.Note;
import com.sang.school.schoolManagement.domain.NoteEleve;

public interface INoteEleveService {
	

	public NoteEleve enregistrerNoteEleve(Note note, Eleve eleve, Double valeurNote);
	
    public List<NoteEleve> listeNoteEleve(); 
    
    public NoteEleve modifierNoteEleveId(Long id, Double valeurNote);
    
    public void supprimerNoteEleveParId(Long id);
    
    public NoteEleve rechercherNoteEleveParId(Long id);
    
    public List<NoteEleve> findByNoteId(Long id);
}
