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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "ParcRoulant")
public class ParcRoulant implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="Code")
	private String Code;
 
	
	@Column(name="date")
	private Date date;
	
	
	@Column(name="Camion")

	private  String Camion;
	
	
	@Column(name="chauffeur")
	
	private String Chaufeur;
	
	@Column(name="heureS")
	private String heureS;
	
	@Column(name="NplombageS")
	private String NplombageS;
	
	@Column(name="KilometrageS")
	private String KilometrageS;
	
	
	@Column(name="heureE")
	private String heureE;
	
	@Column(name="NplombageE")
	private String NplombageE;
	
	@Column(name="KilometrageE")
	private String KilometrageE;
	
	@Column(name="EtatProprete")
	private boolean EtatProprete;

	
	public ParcRoulant(Long id, String code, Date datecreation, Date date, String camion, String chaufeur,
			String heureS, String nplombageS, String kilometrageS, String heureE, String nplombageE,
			String kilometrageE, boolean etatProprete) {
		this.id = id;
		this.Code = code;
		this.date = date;
		this.Camion = camion;
		this.Chaufeur = chaufeur;
		this.heureS = heureS;
		this.NplombageS = nplombageS;
		this.KilometrageS = kilometrageS;
		this.heureE = heureE;
		this.NplombageE = nplombageE;
		this.KilometrageE = kilometrageE;
		this.EtatProprete = etatProprete;
	}
	public ParcRoulant() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		this.Code = code;
	}
 
	 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public  String getCamion() {
		return Camion;
	}
	public void setCamion(String camion) {
		this.Camion = camion;
	}
	
	public  String getChaufeur() {
		return Chaufeur;
	}

	public void setChaufeur(String chaufeur) {
		this.Chaufeur = chaufeur;
	}
	
	public String getHeureS() {
		return heureS;
	}
	public void setHeureS(String heureS) {
		this.heureS = heureS;
	}
	public String getNplombageS() {
		return NplombageS;
	}
	public void setNplombageS(String nplombageS) {
		this.NplombageS = nplombageS;
	}
	public String getKilometrageS() {
		return KilometrageS;
	}
	public void setKilometrageS(String kilometrageS) {
		this.KilometrageS = kilometrageS;
	}
	public String getHeureE() {
		return heureE;
	}
	public void setHeureE(String heureE) {
		this.heureE = heureE;
	}
	public String getNplombageE() {
		return NplombageE;
	}
	public void setNplombageE(String nplombageE) {
		this.NplombageE = nplombageE;
	}
	public String getKilometrageE() {
		return KilometrageE;
	}
	public void setKilometrageE(String kilometrageE) {
		this.KilometrageE = kilometrageE;
	}
	public boolean isEtatProprete() {
		return EtatProprete;
	}
	public void setEtatProprete(boolean etatProprete) {
		this.EtatProprete = etatProprete;
	}
	
	
			

	
	
	
	
}
