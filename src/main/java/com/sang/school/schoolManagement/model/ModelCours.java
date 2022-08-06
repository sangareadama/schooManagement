package com.sang.school.schoolManagement.model;

public class ModelCours {

    private long id ;
	
	private Long typeCourId;

	private String libelle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getTypeCourId() {
		return typeCourId;
	}

	public void setTypeCourId(Long typeCourId) {
		this.typeCourId = typeCourId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
