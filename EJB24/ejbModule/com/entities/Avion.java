package com.entities;

import java.io.Serializable;   
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="AVION")
public class Avion implements Serializable{
	@Id
	@Column(name="ID_AVION")
	 int immatricule;
	@Column(name="NOM_AVION")
	 String nom;
	
	@ManyToOne
	@JoinColumn(name="ID_CONSTRUCTEUR")
	 Constructeur constructeur;
	
	@ManyToMany(mappedBy="avions")
	 List<Pilote>pilotes;

	public int getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(int immatricule) {
		this.immatricule = immatricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	public List<Pilote> getPilotes() {
		return pilotes;
	}

	public void setPilotes(List<Pilote> pilotes) {
		this.pilotes = pilotes;
	}

	public Avion(int immatricule, String nom) {
		super();
		this.immatricule = immatricule;
		this.nom = nom;
	}

	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}