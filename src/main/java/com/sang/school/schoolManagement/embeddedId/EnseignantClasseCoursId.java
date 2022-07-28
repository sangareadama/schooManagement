package com.sang.school.schoolManagement.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnseignantClasseCoursId implements Serializable{
	
	@Column(name = "enseignant")
	private String enseignant ;
	@Column(name = "classe")
	private String classe ;
	@Column(name = "cours")
	private String cours ;
		
	public EnseignantClasseCoursId(String enseignant, String classe, String cours) {
		super();
		this.enseignant = enseignant;
		this.classe = classe;
		this.cours = cours;
	}
	
	public EnseignantClasseCoursId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public String getCours() {
		return cours;
	}


	public void setCours(String cours) {
		this.cours = cours;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((cours == null) ? 0 : cours.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnseignantClasseCoursId other = (EnseignantClasseCoursId) obj;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (cours == null) {
			if (other.cours != null)
				return false;
		} else if (!cours.equals(other.cours))
			return false;
                  
		return true;
	}
	

}
