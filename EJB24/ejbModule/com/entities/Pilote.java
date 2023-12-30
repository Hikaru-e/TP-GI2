package com.entities;

import java.io.Serializable; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="PILOTE")
public class Pilote implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PILOTE")
	 int numero;
	@Column(name="NOM_PILOTE")
	 String nom;
	@Column(name="NTEL")
	 int ntel; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Pilote_Avion",
	joinColumns=@JoinColumn(name="ID_PILOTE"),
	inverseJoinColumns=@JoinColumn(name="ID_AVION")
	)
	 List<Avion> avions;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNtel() {
		return ntel;
	}

	public void setNtel(int ntel) {
		this.ntel = ntel;
	}

	public List<Avion> getAvions() {
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}

	public Pilote(int numero, String nom, int ntel) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.ntel = ntel;
	}

	public Pilote() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
