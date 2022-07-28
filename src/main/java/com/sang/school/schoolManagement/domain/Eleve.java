package com.sang.school.schoolManagement.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "eleve")
public class Eleve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String nom; 
	private String prenom;
	private String matricule;
	private String sexe;
	private String nationalite;
	private String email;
	private String password;
	private String telephone;
	private String address; 
	private Date dateDeNaissance;
	private String classes=" ";	
	  @Lob
	  private String photo;
	 
	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
	public Eleve(String nom, String prenom, String matricule, String sexe, String nationalite,
			String email, String password, String telephone, String address, Date dateDeNaissance, String classes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.address = address;
		this.dateDeNaissance = dateDeNaissance;
		this.classes = classes;
	}

 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
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



	public String getClasses() {
		return classes;
	}



	public void setClasses(String classes) {
		this.classes = classes;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}



	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	  public String getPhoto() { return photo; }
	  
	  
	  
	  public void setPhoto(String photo) { this.photo = photo; }
	 
	
	

} 
