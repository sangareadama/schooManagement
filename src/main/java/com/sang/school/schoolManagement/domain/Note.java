package com.sang.school.schoolManagement.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne 
	private TypeNote typeNote;
	@ManyToOne
	private Cours matiere;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Classe classe;
	private Date dateNote;
	private String heureDebut;
	private String heureFin;
	
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Note(TypeNote typeNote, Cours matiere,Enseignant enseignant,Classe classe, Date dateNote, String heureDebut, String heureFin) {
		super();
		this.typeNote = typeNote;
		this.matiere = matiere;
		this.enseignant=enseignant;
		this.classe=classe;
		this.dateNote = dateNote;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	
	public TypeNote getTypeNote() {
		return typeNote;
	}
	public void setTypeNote(TypeNote typeNote) {
		this.typeNote = typeNote;
	}
	public Cours getMatiere() {
		return matiere;
	}
	public void setMatiere(Cours matiere) {
		this.matiere = matiere;
	}
	public Date getDateNote() {
		return dateNote;
	}
	public void setDateNote(Date dateNote) {
		this.dateNote = dateNote;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	} 
	
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	

}
