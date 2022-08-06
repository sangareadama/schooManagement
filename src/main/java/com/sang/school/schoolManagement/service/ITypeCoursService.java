package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.TypeCours;

public interface ITypeCoursService {
	
	    public TypeCours enregistrerTypeCours(TypeCours typeCours);
		
	    public List<TypeCours> listeTypeCours();
	    
	    public TypeCours modifierTypeCoursParId(Long id, String libelle);
	    
	    public void supprimerTypeCoursParId(Long id); 
	    
	    public TypeCours rechercherTypeCoursParId(Long id);

}
