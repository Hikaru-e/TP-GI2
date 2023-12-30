package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Pilote;


@Local
public interface ILocal_PiloteLocal {


    public void addPilote(Pilote a);
    public void deletePilote(int code) ;
    public void updatePilote(Pilote a);
    public Pilote getPilote( int code);
    public List<Pilote> getallPilote ();
}
