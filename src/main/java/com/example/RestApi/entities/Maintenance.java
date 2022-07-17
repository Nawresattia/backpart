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
@Table(name = "Maintenance")
public class Maintenance implements Serializable{
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="demandeur")
	private String Demandeur;
	
	@Column(name="site")
	private String Site;
	
	@Column(name="referenceOt")
	private String ReferenceOt;
	
	@Column(name="equipement")
	private String Equipement;
	
	@Column(name="nature_demande")
	private String nature_demande;
	
	@Column(name = "date")
	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDemandeur() {
		return Demandeur;
	}


	public void setDemandeur(String demandeur) {
		this.Demandeur = demandeur;
	}


	public String getSite() {
		return Site;
	}


	public void setSite(String site) {
		this.Site = site;
	}


	public String getReferenceOt() {
		return ReferenceOt;
	}


	public void setReferenceOt(String referenceOt) {
		this.ReferenceOt = referenceOt;
	}


	public String getEquipement() {
		return Equipement;
	}


	public void setEquipement(String equipement) {
		this.Equipement = equipement;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getNature_demande() {
		return nature_demande;
	}


	public void setNature_demande(String nature_demande) {
		this.nature_demande = nature_demande;
	}
	
	
	
	
	

}
