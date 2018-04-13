package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.BlogKateg;

/**
 * Session Bean implementation class BlogKategorijeBean
 */
@Startup
@Singleton
@LocalBean
public class BlogKategorijeBean implements BlogKategorijeBeanLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public BlogKategorijeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<BlogKateg> getKategorije() {
	
		try {
			Query q = em.createQuery("SELECT bk FROM BlogKateg bk");
			
			return q.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
