package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.local;

@Local
public interface ILocal_localLocal {

	public void addLocal(local a);
    public void deleteLocal(int code) ;
    public void updateLocal(local a);
    public local getLocal( int code);
    public List<local> getallLocal ();
	
}
