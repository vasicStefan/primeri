package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Blog;

/**
 * Session Bean implementation class BlogPretraga
 */
@Stateless
@LocalBean
public class BlogPretraga implements BlogPretragaLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BlogPretraga() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Blog> pretrazi(String text) {
		Query q = em.createQuery("SELECT b from Blog b WHERE b.text like :likeText");
		q.setParameter("likeText", "%"+text+"%");
		return q.getResultList();
		
	}

}
