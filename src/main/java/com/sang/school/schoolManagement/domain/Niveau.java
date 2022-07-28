package com.sang.school.schoolManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author SANGARE
 *
 */
@Entity
public class Niveau {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String libelle;
	@ManyToOne
	private Cycle cycle;
 
	public Niveau() { 
		super();
		// TODO Auto-generated constructor stub
	}



	public Niveau(String libelle, Cycle cycle) {
		super();
		this.libelle = libelle;
		this.cycle = cycle;
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



	public Cycle getCycle() {
		return cycle;
	}



	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	
	
	
	

}
