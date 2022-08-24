package com.sang.school.schoolManagement.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames ="email"))
public class Utilisateur {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private	long id;
    private String nom;
    private String prenom;
    private String email;
    private String password; 
	  @Lob 
	  private String nomPhoto;
	 

    private boolean enabled=true;
    @ManyToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "UtilisateurRoles",
			joinColumns = @JoinColumn(
					name="UtilisateurId",referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
					name="RoleId",referencedColumnName = "id"
					)
			)
 	private Collection<Role>  roles ;
    
	public boolean isEnabled() {
		return enabled;
	} 

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Utilisateur(String nom, String prenom, String email, String password,
			Collection<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.roles = roles;
		 
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
	
	
	  public String getNomPhoto() { return nomPhoto; }
	  
	  public void setNomPhoto(String nomPhoto) { this.nomPhoto = nomPhoto; }
	 

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	}
    

}
