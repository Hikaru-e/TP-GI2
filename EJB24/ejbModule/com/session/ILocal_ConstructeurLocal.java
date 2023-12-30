package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Constructeur;

@Local
public interface ILocal_ConstructeurLocal {
	
	    public void addConstructeur(Constructeur a);
	    public void deleteConstructeur(int code) ;
	    public void updateConstructeur(Constructeur a);
	    public Constructeur getConstructeur( int code);
	    public List<Constructeur> getallConstructeur ();
	
	
}
