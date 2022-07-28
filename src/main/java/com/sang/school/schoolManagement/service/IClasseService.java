package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Niveau;

public interface IClasseService {
	
    public Classe enregistrerClasse(Niveau niveau, String designation);
	
    public List<Classe> listeClasse();
    
    public Classe modifierClasseParId(Long id, Niveau niveau, String designation);
    
    public void supprimerClasseParId(Long id);
    
    public Classe rechercherClasseParId(Long id);

    
}
