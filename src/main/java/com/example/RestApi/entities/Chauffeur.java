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
@Table(name = "Chauffeur")
public class Chauffeur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name="nomchauffeur")
	private String nomchauffeur;
	
	@Column(name="prenomchauffeur")
	private String prenomchauffeur;
	
	@Column(name="site")
	private String site;
	
	@Column(name="cin")
	private String cin;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name = "createdat")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date createdat;
	
	
	

	public Chauffeur(Long id, String nomchauffeur, String prenomchauffeur,String site, String cin, String tel, Date createdat) {
	
		this.id = id;
		this.nomchauffeur = nomchauffeur;
		this.prenomchauffeur = prenomchauffeur;
		this.site=site;
		this.cin = cin;
		this.tel = tel;
		this.createdat = createdat;
	}
	public Chauffeur() {}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomchauffeur() {
		return nomchauffeur;
	}

	public void setNomchauffeur(String nomchauffeur) {
		this.nomchauffeur = nomchauffeur;
	}

	public String getPrenomchauffeur() {
		return prenomchauffeur;
	}

	public void setPrenomchauffeur(String prenomchauffeur) {
		this.prenomchauffeur = prenomchauffeur;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

 
	
	
	
	

}
