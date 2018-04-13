package beans;


import javax.ejb.Remote;

import model.Blog;
import model.BlogKorisnik;

@Remote
public interface BlogBeanLocal {

	BlogKorisnik login(String username, String password);
	Blog addBlog(BlogKorisnik k, int blogKategorija, String text, int likesNo);
	
}
