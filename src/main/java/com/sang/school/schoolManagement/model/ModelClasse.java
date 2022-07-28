package com.sang.school.schoolManagement.model;

public class ModelClasse {
	
private long id ;
	
private Long niveauId;

private String designation;

public Long getNiveauId() {
	return niveauId;
}

public void setNiveauId(Long niveauId) {
	this.niveauId = niveauId;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

}
