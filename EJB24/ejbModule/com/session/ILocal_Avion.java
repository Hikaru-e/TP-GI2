package com.session;

import java.util.List; 

import javax.ejb.LocalBean; 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entities.Avion;


@Stateless
@LocalBean
public class ILocal_Avion implements ILocal_AvionLocal {

	@PersistenceContext
	EntityManager mn;
	
    public ILocal_Avion() {
        // TODO Auto-generated constructor stub
    }

	public void addAvion(Avion a) {
		mn.persist(a);
		
	}

	public void deleteAvion(int code) {
		Avion a=mn.find(Avion.class, code);
       mn.remove(a);		
	}

	public void updateAvion(Avion a) {
		mn.merge(a);
	}
	
	@Transactional
	public Avion getAvion(int code) {
		
		Avion a = mn.find(Avion.class, code);
		a.getPilotes().size();
		return a;
		
	}

	@Transactional
	public List<Avion> getallAvion() {

		Query q= mn.createQuery("select p from Avion p");
		List<Avion> avions = q.getResultList();
		for (Avion avion : avions) {
	        avion.getPilotes().size(); // This triggers lazy loading
	    }

		return avions;
	}

 
    
}
