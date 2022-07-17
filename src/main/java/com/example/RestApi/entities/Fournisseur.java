package com.example.RestApi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Fournisseur")
public class Fournisseur  implements Serializable  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="nom")
	private String Nom;
	
	@Column(name="code")
	private String code;
	
	@Column(name="type")
	private String type;
	
	@Column(name="datecreation")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date Datecreation;
	
	
	
	
 public Fournisseur(Long id, String nom, String code, String type, Date datecreation) {
		this.id = id;
		this.Nom = nom;
		this.code = code;
		this.type = type;
		this.Datecreation = datecreation;
	}

	
public Fournisseur() {}


public Date getDatecreation() {
		return Datecreation;
	}

 

public void setDatecreation(Date datecreation) {
	this.Datecreation = datecreation;
}



 

public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNom() {
	return Nom;
}


public void setNom(String nom) {
	this.Nom = nom;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}

 
 
	
	
}
