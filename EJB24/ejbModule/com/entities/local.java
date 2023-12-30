package com.entities;

import java.io.Serializable;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="LOCAL")
public class local implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LOCAL")
	 int id_local;
	

	@Column(name="ADRESSE_LOCAL")
	 String adresse;
	@Column(name="SUPERFICIE_LOCAL")
	 Float superficie;
	
	@OneToOne(mappedBy = "local")
	 Constructeur constructeur;

	public int getId_local() {
		return id_local;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Float superficie) {
		this.superficie = superficie;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	public local(int id_local, String adresse, Float superficie) {
		super();
		this.id_local = id_local;
		this.adresse = adresse;
		this.superficie = superficie;
	}

	public local() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
