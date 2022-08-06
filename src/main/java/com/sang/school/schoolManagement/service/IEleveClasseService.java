package com.sang.school.schoolManagement.service;

import java.util.List;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.EleveClasse;
import com.sang.school.schoolManagement.embeddedId.EleveClasseId;

public interface IEleveClasseService {
	
	
	public EleveClasse enregistrerEleveClasse(Eleve eleve, Classe classe);
	
	public EleveClasse modifierEleveClasse(EleveClasseId id ,Eleve eleve, Classe classe);
	
	public void SupprimerEleveClasseParid(EleveClasse eleveClasse);
	
	public  List<EleveClasse> findByEleveId(Long id);
	
	public  List<EleveClasse> findByClasseId(Long id);

}
