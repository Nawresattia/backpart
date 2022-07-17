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
@Table(name = "Reception")
public class Reception  implements Serializable  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Entrepot")
	private String Entrepot;
	
	
	   
		 @Column(name = "date")
		 @JsonFormat(pattern="yyyy-MM-dd")
	     private Date date;
		

	@Column(name="Heure_arrive")
	@JsonFormat(pattern="HH-MM")
	private String Heure_arrive;
	
	
	
	  @Column(name="Heure_entre")
	  @JsonFormat(pattern="HH-MM")
		private String Heure_entre ;
	  
		
		 
	  @Column(name="Heure_depart")
	  @JsonFormat(pattern="HH-MM")
			private String Heure_depart ;



	public Reception(Long id, String entrepot, Date date, String heure_arrive, String heure_entre,
			String heure_depart) {
		super();
		this.id = id;
		this.Entrepot = entrepot;
		this.date = date;
		this.Heure_arrive = heure_arrive;
		this.Heure_entre = heure_entre;
		this.Heure_depart = heure_depart;
	}
	

public Reception() {}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEntrepot() {
		return Entrepot;
	}

 

	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getHeure_arrive() {
		return Heure_arrive;
	}



	public void setHeure_arrive(String heure_arrive) {
		this.Heure_arrive = heure_arrive;
	}



	public String getHeure_entre() {
		return Heure_entre;
	}



	public void setHeure_entre(String heure_entré) {
		this.Heure_entre = heure_entré;
	}



	public String getHeure_depart() {
		return Heure_depart;
	}



	public void setHeure_depart(String heure_depart) {
		this.Heure_depart = heure_depart;
	}


	public void setEntrepot(String entrepot) {
		this.Entrepot = entrepot;
		
	}


	 
	
	  
	  
}

  
   
 

