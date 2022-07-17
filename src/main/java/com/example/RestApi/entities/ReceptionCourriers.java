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
@Table(name = "ReceptionCourriers")
public class ReceptionCourriers implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "date")
	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
	
	@Column(name="reference")
	private  String reference;
	
	@Column(name="Entrepot")
	private String Entrepot;
	
	@Column(name="Chaufeur")
	
	private String Chaufeur;

	
	
	public ReceptionCourriers(Long id, Date date, String reference, String entrepot, String chaufeur) {
		this.id = id;
		this.date = date;
		this.reference = reference;
		this.Entrepot = entrepot;
		this.Chaufeur = chaufeur;
	}
	public ReceptionCourriers() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getEntrepot() {
		return Entrepot;
	}

	public void setEntrepot(String entrepot) {
		this.Entrepot = entrepot;
	}

	public String getChaufeur() {
		return Chaufeur;
	}

	public void setChaufeur(String chaufeur) {
		this.Chaufeur = chaufeur;
	}

	 

	 
	
	
	

}
