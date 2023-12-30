package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Avion;

@Local
public interface ILocal_AvionLocal {

	    public void addAvion(Avion a);
	    public void deleteAvion(int code) ;
	    public void updateAvion(Avion a);
	    public Avion getAvion( int code);
	    public List<Avion> getallAvion ();
}

