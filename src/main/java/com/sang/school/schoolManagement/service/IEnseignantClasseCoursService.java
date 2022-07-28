package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.EnseignantClasseCours;
import com.sang.school.schoolManagement.embeddedId.EnseignantClasseCoursId;

public interface IEnseignantClasseCoursService {
	
    public EnseignantClasseCours enregistrerEnseignantClasseCours(Enseignant enseignant, Classe classe, Cours cours);
	
	public EnseignantClasseCours modifierEnseignantClasseCours(EnseignantClasseCoursId id ,Enseignant enseignant, Classe classe, Cours cours);
	
	public void SupprimerEnseignantClasseCoursParid(EnseignantClasseCours enseignantClasseCours);
	
	public List<EnseignantClasseCours> findByEnseignantId(Long id);
	
	public List<EnseignantClasseCours> findByClasseId(Long id); 

}
