package com.example.RestApi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Camion")
public class Camion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name="immatricule")
	private String immatricule;
	
	
	@Column(name="type")
	private String type;
	
	@Column(name="taille")
	private String taille;
	
	
 	@Column(name="chauffeur")
 	
 	private String chauffeur;

	@Column(name = "datecreation")
	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date datecreation;
	
	

	
	public Camion(Long id, String immatricule, String type, String taille, String chauffeur, Date datecreation) {
		super();
		this.id = id;
		this.immatricule = immatricule;
		this.type = type;
		this.taille = taille;
		this.chauffeur = chauffeur;
		this.datecreation = datecreation;
	}
	public Camion() {}
	public Long getId() {
		return id;
	}
	public String getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(String chauffeur) {
		this.chauffeur = chauffeur;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	
	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	 

	
	
	
}
