package com.sang.school.schoolManagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sang.school.schoolManagement.embeddedId.EleveClasseId;

@Entity
public class EleveClasse {
	
	 
	@Embedded
	@Id
	private EleveClasseId id = new EleveClasseId();
	
	@ManyToOne
	private Eleve eleve ;
	@ManyToOne 
	private Classe classe ;
	
	public EleveClasse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EleveClasse(Eleve eleve, Classe classe) {
		super();
		this.id.setEleve(eleve.getNom());
		this.id.setClasse(classe.getNiveau().getLibelle()+" - "+classe.getDesignation());
		this.eleve = eleve;
		this.classe = classe;
	}
 
	public EleveClasseId getId() {
		return id;
	}

	public void setId(EleveClasseId id) {
		this.id = id;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
	
	

}
