package com.sang.school.schoolManagement.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EleveClasseId  implements Serializable{

	@Column(name = "eleve")
	private String eleve ;
	@Column(name = "classe")
	private String classe ;
	
	public EleveClasseId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EleveClasseId(String eleve, String classe) {
		super();
		this.eleve = eleve;
		this.classe = classe;
	}

	public String getEleve() {
		return eleve;
	}
	public void setEleve(String eleve) {
		this.eleve = eleve;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eleve == null) ? 0 : eleve.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
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
		EleveClasseId other = (EleveClasseId) obj;
		if (eleve == null) {
			if (other.eleve != null)
				return false;
		} else if (!eleve.equals(other.eleve))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
                  
		return true;
	}
	
	
}
