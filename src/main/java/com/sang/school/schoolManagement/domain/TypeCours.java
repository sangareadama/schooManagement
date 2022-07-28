package com.sang.school.schoolManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeCours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String libelle;
	
	public TypeCours() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	public TypeCours(String libelle) {
		super();
		this.libelle = libelle;
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

	
	
	

}
