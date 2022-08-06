package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.TypeCours;

public interface ICoursService {

    public Cours enregistrerCours(String libelle,TypeCours typeCours);
	
    public List<Cours> listeCours();
    
    public Cours modifierCoursParId(Long id, String libelle,TypeCours typeCours);
    
    public void supprimerCoursParId(Long id);
    
    public Cours rechercherCoursParId(Long id);

}
