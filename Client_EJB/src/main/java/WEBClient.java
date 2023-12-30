import java.util.List; 

import javax.ejb.EJB; 
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.entities.Avion;
import com.entities.Constructeur;
import com.entities.Pilote;
import com.entities.local;
import com.session.ILocal_AvionLocal;
import com.session.ILocal_ConstructeurLocal;
import com.session.ILocal_PiloteLocal;
import com.session.ILocal_localLocal;

@WebService
public class WEBClient {
	
   @EJB
	ILocal_AvionLocal localAvion ;
	@WebMethod
	public void insertAvion(@WebParam(name="code_avion") int code ,@WebParam(name="nom_avion") String nom) {
		Avion a = new Avion();
		a.setImmatricule(code);
		a.setNom(nom);
		localAvion.addAvion(a);
	}
	
	@WebMethod
	public void deleteAvion(@WebParam(name="code_avion") int code ) {
		localAvion.deleteAvion(code);
	}
	
	@WebMethod
	public Avion getAvion(@WebParam(name="code_avion") int code ) {
		return localAvion.getAvion(code);
	}
	
	@WebMethod
	public List<Avion> Avions() {
		return localAvion.getallAvion();
	}

	@WebMethod
	public void updateAvion(@WebParam(name="code_avion") int code,@WebParam(name="nom_avion") String nom ) {
		Avion a = new Avion();
		a.setImmatricule(code);
		a.setNom(nom);
		localAvion.updateAvion(a);
	}
	
	
	
	
	
	
	@EJB
	ILocal_PiloteLocal localPilote ;
	@WebMethod
	public void insertPilote(@WebParam(name="code_Pilote") int code ,@WebParam(name="nom_Pilote") String nom,@WebParam(name="ntel_Pilote") int ntel) {
		Pilote a = new Pilote();
		a.setNumero(code);
		a.setNom(nom);
		a.setNtel(ntel);
		localPilote.addPilote(a);
	}
	
	@WebMethod
	public void deletePilote(@WebParam(name="code_Pilote") int code ) {
		localPilote.deletePilote(code);
	}
	
	@WebMethod
	public Pilote getPilote(@WebParam(name="code_Pilote") int code ) {
		return localPilote.getPilote(code);
	}
	
	@WebMethod
	public List<Pilote> Pilotes() {
		return localPilote.getallPilote();
	}

	@WebMethod
	public void updatePilote(@WebParam(name="code_Pilote") int code,@WebParam(name="nom_Pilote") String nom,@WebParam(name="ntel_Pilote") int ntel ) {
		
		Pilote a = new Pilote();
		a.setNumero(code);
		a.setNom(nom);
		a.setNtel(ntel);
		localPilote.updatePilote(a);
	}
	
	
	
	
	
	
	@EJB
	ILocal_ConstructeurLocal constructeurlocal;
	@WebMethod
	public void insertconstructeur(@WebParam(name="code_constructeur") int code ,@WebParam(name="nom_constructeur") String nom,@WebParam(name="adr_constructeur") String adr) {
		Constructeur a = new Constructeur();
		a.setAdresse(adr);
		a.setCode(code);
		a.setNom(nom);
		constructeurlocal.addConstructeur(a);
	}
	
	@WebMethod
	public void deleteConstructeur(@WebParam(name="code_constructeur") int code ) {
		constructeurlocal.deleteConstructeur(code);
	}
	
	@WebMethod
	public Constructeur getConstructeur(@WebParam(name="code_constructeur") int code ) {
		return constructeurlocal.getConstructeur(code);
	}
	
	@WebMethod
	public List<Constructeur> constructeurs() {
		return constructeurlocal.getallConstructeur();
	}

	
	@EJB
	ILocal_localLocal local_local;
	@WebMethod
	public void insertLocal(@WebParam(name="code_local") int code ,@WebParam(name="superficie_local") Float superficie,@WebParam(name="adr_constructeur") String adr) {
		local a = new local();
		a.setAdresse(adr);
		a.setId_local(code);
		a.setSuperficie(superficie);
		local_local.addLocal(a);
	}
	
	
	
	
	
}