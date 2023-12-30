package com.entities;

import java.io.Serializable;  
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="CONSTRUCTEUR")
public class Constructeur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONSTRUCTEUR")
	 int code;
	

	@Column(name="NOM_CONSTRUCTEUR")
	 String nom;
	@Column(name="ADRESSE_CONSTRUCTEUR")
	 String adresse;
	
	@OneToMany(mappedBy="constructeur")
	 List<Avion> avions;
	
	@OneToOne
	@JoinColumn(name="ID_LOCAL",unique=true)
	 local local;
	
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Avion> getAvions() {
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}

	public local getLocal() {
		return local;
	}

	public void setLocal(local local) {
		this.local = local;
	}

	public Constructeur(int code, String nom, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}

	public Constructeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
