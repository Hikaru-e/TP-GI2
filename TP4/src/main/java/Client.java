import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@ManagedBean
@SessionScoped
public class Client {
	int code;
	String civilite;
	String nom;
	String prenom;
	Integer cp;
	String ville;
	Date dateN;
	String mail;
	Long tel;
	List<Client> listClient = new ArrayList<Client>();
	public Client() {
		super();
	}

	public Client(String civilite, String nom, String prenom, Integer cp, String ville, Date dateN, String mail,
			Long tel) {
		super();

		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.cp = cp;
		this.ville = ville;
		this.dateN = dateN;
		this.mail = mail;
		this.tel = tel;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	public void SaveClient() {
		SessionFactory SF = null;
		Session session = null;
		Transaction Tx = null;
		try {
			SF = new Configuration().configure().buildSessionFactory();
			session = SF.openSession();
			Tx = session.beginTransaction();
			Client c = new Client();
			c.setNom(nom);
			c.setCivilite(civilite);
			c.setCp(cp);
			c.setDateN(dateN);
			c.setPrenom(prenom);
			c.setTel(tel);
			c.setVille(ville);
			c.setMail(mail);

			session.save(c);

			Tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
		SessionFactory SF = null;
		Session session = null;
		Transaction Tx = null;
		try {
			SF = new Configuration().configure().buildSessionFactory();
			session = SF.openSession();
			Tx = session.beginTransaction();

			listClient = session.createQuery("from Client").list();

			Tx.commit();
			return listClient;
		} catch (Exception e) {
			if (Tx != null) {
				e.printStackTrace();
				Tx.rollback();
			}
		}
		return listClient;

	}

	public boolean deleteClient(Client l) {
		SessionFactory SF = null;
		Session session = null;
		Transaction Tx = null;
		try {
			SF = new Configuration().configure().buildSessionFactory();
			session = SF.openSession();
			Tx = session.beginTransaction();

			session.delete(l);

			Tx.commit();

			return true;
		} catch (Exception e) {
			if (Tx != null) {
				e.printStackTrace();
				Tx.rollback();
			}
		}
		return false;
	}

}
