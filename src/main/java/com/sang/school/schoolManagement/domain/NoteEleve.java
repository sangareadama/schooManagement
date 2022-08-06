package com.sang.school.schoolManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NoteEleve {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Note note;
	@ManyToOne
	private Eleve eleve;
	private Double valeurNote;
	
	
	public NoteEleve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteEleve(Note note, Eleve eleve, Double valeurNote) {
		super();
		this.note = note;
		this.eleve = eleve;
		this.valeurNote = valeurNote;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Double getValeurNote() {
		return valeurNote;
	}
	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}
	
	
}
