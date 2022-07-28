package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Cycle;
import com.sang.school.schoolManagement.domain.Niveau;

public interface INiveauService {
	
	public Niveau enregistrerNiveau(String libelle, Cycle cycle);
	
    public List<Niveau> listeNiveau();
    
    public Niveau modifierNiveauParId(Long id, String libelle, Cycle cycle);
    
    public void supprimerNiveauParId(Long id);
    
    public Niveau rechercherNiveauParId(Long id);


}
