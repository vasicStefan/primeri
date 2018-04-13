package beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Blog;
import model.BlogKateg;
import model.BlogKorisnik;

/**
 * Session Bean implementation class BlogBean
 */
@Stateful
@LocalBean
public class BlogBean implements BlogBeanLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BlogBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PreDestroy
    public void unisten() {
    	System.out.println("Unisten BlogBean");
    }
    
    @PostConstruct
    public void napravljen() {
    	System.out.println("Napravljen");
    }

	@Override
	public BlogKorisnik login(String username, String password) {
		Query q = em.createQuery("SELECT bk FROM BlogKorisnik bk WHERE bk.username =:username AND bk.password =:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		List<BlogKorisnik> bkL = q.getResultList();
		
 		return bkL.get(0);
	}

	@Override
	public Blog addBlog(BlogKorisnik k, int blogKategorija, String text, int likesNo) {
		Blog b = new Blog();
		b.setBlogKorisnik(k);
		b.setText(text);
		b.setDatum(new Date());
		em.find(BlogKateg.class, blogKategorija);
		b.setBlogKateg(em.find(BlogKateg.class, blogKategorija));
		em.persist(b);
		
		return b;
	}

}
