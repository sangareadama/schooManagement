package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.TypeNote;

public interface ITypeNoteService {
	
	public TypeNote enregistrerTypeNote(TypeNote typeNote);
	
    public List<TypeNote> listeTypeNote();
    
    public TypeNote modifierTypeNoteParId(Long id, String libelle);
    
    public void supprimerTypeNoteParId(Long id); 
    
    public TypeNote rechercherTypeNoteParId(Long id);


}
