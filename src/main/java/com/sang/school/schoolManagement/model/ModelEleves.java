package com.sang.school.schoolManagement.model;

import java.sql.Date;

public class ModelEleves {
	
	private long id;
	private String matricule;
	private String nom ;
	private String prenom;
	private Date dateDeNaissance;
	private String lieuDeNaissance;
	private String sexe;
	private String nationalite;
	
	private String nomDuPere;
	private String prenomDuPere;
	private String adresseDuPere;
	private long contactDuPere;
	private String nomDeLaMere;
	private String prenomDeLaMere;
	private long contactDeLaMere;
	private String adresseDeLaMere;
	private String nomDuTuteur;
	private String prenomDuTuteur;
	private long contactDuTuteur;
	private String adresseDuTuteur;
	
	private String redoublant;
	private String regime;
	private String affecte;
	private String interne;
	private long classeId;

	public String getRedoublant() {
		return redoublant;
	}

	public void setRedoublant(String redoublant) {
		this.redoublant = redoublant;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getAffecte() {
		return affecte;
	}

	public void setAffecte(String affecte) {
		this.affecte = affecte;
	}

	public String getInterne() {
		return interne;
	}

	public void setInterne(String interne) {
		this.interne = interne;
	}

	public String getNomDuPere() {
		return nomDuPere;
	}

	public void setNomDuPere(String nomDuPere) {
		this.nomDuPere = nomDuPere;
	}

	public String getPrenomDuPere() {
		return prenomDuPere;
	}

	public void setPrenomDuPere(String prenomDuPere) {
		this.prenomDuPere = prenomDuPere;
	}

	public String getAdresseDuPere() {
		return adresseDuPere;
	}

	public void setAdresseDuPere(String adresseDuPere) {
		this.adresseDuPere = adresseDuPere;
	}

	public long getContactDuPere() {
		return contactDuPere;
	}

	public void setContactDuPere(long contactDuPere) {
		this.contactDuPere = contactDuPere;
	}

	public String getNomDeLaMere() {
		return nomDeLaMere;
	}

	public void setNomDeLaMere(String nomDeLaMere) {
		this.nomDeLaMere = nomDeLaMere;
	}

	public String getPrenomDeLaMere() {
		return prenomDeLaMere;
	}

	public void setPrenomDeLaMere(String prenomDeLaMere) {
		this.prenomDeLaMere = prenomDeLaMere;
	}

	public long getContactDeLaMere() {
		return contactDeLaMere;
	}

	public void setContactDeLaMere(long contactDeLaMere) {
		this.contactDeLaMere = contactDeLaMere;
	}

	public String getAdresseDeLaMere() {
		return adresseDeLaMere;
	}

	public void setAdresseDeLaMere(String adresseDeLaMere) {
		this.adresseDeLaMere = adresseDeLaMere;
	}

	public String getNomDuTuteur() {
		return nomDuTuteur;
	}

	public void setNomDuTuteur(String nomDuTuteur) {
		this.nomDuTuteur = nomDuTuteur;
	}

	public String getPrenomDuTuteur() {
		return prenomDuTuteur;
	}

	public void setPrenomDuTuteur(String prenomDuTuteur) {
		this.prenomDuTuteur = prenomDuTuteur;
	}

	public long getContactDuTuteur() {
		return contactDuTuteur;
	}

	public void setContactDuTuteur(long contactDuTuteur) {
		this.contactDuTuteur = contactDuTuteur;
	}

	public String getAdresseDuTuteur() {
		return adresseDuTuteur;
	}

	public void setAdresseDuTuteur(String adresseDuTuteur) {
		this.adresseDuTuteur = adresseDuTuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public long getClasseId() {
		return classeId;
	}

	public void setClasseId(long classeId) {
		this.classeId = classeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
