package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Pilote;

@Stateless
@LocalBean
public class ILocal_Pilote implements ILocal_PiloteLocal {

	@PersistenceContext
	EntityManager mn;
	
    public ILocal_Pilote() {
        // TODO Auto-generated constructor stub
    }
    
    public void addPilote(Pilote a) {
		mn.persist(a);
	}

	public void deletePilote(int code) {
		Pilote a=mn.find(Pilote.class, code);
       mn.remove(a);		
	}

	public void updatePilote(Pilote a) {
		mn.merge(a);
	}

	public Pilote getPilote(int code) {
		
		Pilote a = mn.find(Pilote.class, code);
		return a;
		
	}

	public List<Pilote> getallPilote() {

		Query q= mn.createQuery("select p from Pilote p");
		return q.getResultList();
	}


}
