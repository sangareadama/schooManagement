package com.sang.school.schoolManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String libelle;
	@ManyToOne
	private TypeCours typeCours;
	
	
	
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cours(String libelle,TypeCours typeCours) {
		super();
		this.libelle = libelle;
		this.typeCours=typeCours;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public TypeCours getTypeCours() {
		return typeCours;
	}
	public void setTypeCours(TypeCours typeCours) {
		this.typeCours = typeCours;
	}
	
	
}
