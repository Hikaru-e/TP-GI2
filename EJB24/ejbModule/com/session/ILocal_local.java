package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entities.Avion;
import com.entities.Constructeur;
import com.entities.local;


@Stateless
@LocalBean
public class ILocal_local implements ILocal_localLocal {


	@PersistenceContext
	EntityManager mn;
	
  
    public ILocal_local() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addLocal(local a) {
      
		mn.persist(a);
		
	}

	@Override
	public void deleteLocal(int code) {
		// TODO Auto-generated method stub
		local l =mn.find(local.class, code);
		mn.remove(l);
	}

	@Override
	public void updateLocal(local a) {
		// TODO Auto-generated method stub
		mn.merge(a);
	}

	@Transactional
	public local getLocal(int code) {
		
		local a = mn.find(local.class, code);
		
		return a;
	}

	@Override
	public List<local> getallLocal() {
		Query q= mn.createQuery("select p from local p");
		return q.getResultList();

	}

    
    
    
}
