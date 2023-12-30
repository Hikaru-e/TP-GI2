package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entities.Constructeur;


@Stateless
@LocalBean
public class ILocal_Constructeur implements ILocal_ConstructeurLocal {

	@PersistenceContext
	EntityManager mn;
	
    public ILocal_Constructeur() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addConstructeur(Constructeur a) {
		mn.persist(a);
		
	}

	@Override
	public void deleteConstructeur(int code) {
		Constructeur c = mn.find(Constructeur.class, code);
		mn.remove(c);
		
	}

	@Override
	public void updateConstructeur(Constructeur a) {
		
		mn.merge(a);
	}
	@Transactional
	public Constructeur getConstructeur(int code) {
		Constructeur c = mn.find(Constructeur.class, code);

		return c;
	}

	@Override
	public List<Constructeur> getallConstructeur() {
		Query q= mn.createQuery("select c from Constructeur c");
		return q.getResultList();
	}

    
    
    
}
