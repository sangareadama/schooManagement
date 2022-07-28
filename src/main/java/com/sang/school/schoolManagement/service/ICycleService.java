package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Cycle;

public interface ICycleService {
	
    public Cycle enregistrerCycle(Cycle cycle);
	
    public List<Cycle> listeCycle();
    
    public Cycle modifierCycleParId(Long id, String libelle);
    
    public void supprimerCycleParId(Long id);
    
    public Cycle rechercherCycleParId(Long id);


}
