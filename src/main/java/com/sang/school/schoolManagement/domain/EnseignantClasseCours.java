package com.sang.school.schoolManagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sang.school.schoolManagement.embeddedId.EleveClasseId;
import com.sang.school.schoolManagement.embeddedId.EnseignantClasseCoursId;

@Entity
public class EnseignantClasseCours {

	@Embedded
	@Id
	private EnseignantClasseCoursId id = new EnseignantClasseCoursId();
	
	@ManyToOne
	private Enseignant enseignant ;
	@ManyToOne 
	private Classe classe ;
	@ManyToOne 
	private Cours cours ;
	
	public EnseignantClasseCours() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	public EnseignantClasseCours(Enseignant enseignant, Classe classe, Cours cours) {
		super();
		this.id.setEnseignant(enseignant.getNom());
		this.id.setClasse(classe.getDesignation());
		this.id.setCours(cours.getLibelle());
		this.enseignant = enseignant;
		this.classe = classe;
		this.cours = cours;
	}

	public EnseignantClasseCoursId getId() {
		return id;
	}

	public void setId(EnseignantClasseCoursId id) {
		this.id = id;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
	
}
