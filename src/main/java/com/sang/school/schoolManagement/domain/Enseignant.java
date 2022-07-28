package com.sang.school.schoolManagement.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "enseignant")
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom; 
	private String prenom;
	private String email;
	private String telephone;
	private String sexe;
	private Date dateDeNaissance;
	private String nationalite;
	private String address;
	//@Lob 
	//@Column(length=2147483647)
	private String photo; 
	  
	
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Enseignant(String nom, String prenom, String email, String password, String telephone, String sexe,
			Date dateDeNaissance, String nationalite, String address) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.sexe = sexe;
		this.dateDeNaissance = dateDeNaissance;
		this.nationalite = nationalite;
		this.address = address;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	  public String getPhoto() { return photo; }
	  
	  
	  public void setPhoto(String photo) { this.photo = photo; }
	 
	
	
	

}
