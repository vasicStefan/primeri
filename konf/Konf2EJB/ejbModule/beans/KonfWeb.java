package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Conference;

/**
 * Session Bean implementation class KonfWeb
 */
@Stateless
@LocalBean
@WebService
public class KonfWeb implements KonfWebRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public KonfWeb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@WebMethod
	public List<Conference> getKonferencije(String field) {
		Date datum = new Date();
		
			Query q = em.createQuery("SELECT c from Conference c WHERE c.field =:field AND c.dateFrom <:datum");
			q.setParameter("field", field);
			q.setParameter("datum", datum);
			return q.getResultList();
		
		
	}

}
