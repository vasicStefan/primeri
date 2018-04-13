package beans;

import java.util.List;

import javax.ejb.Local;

import model.BlogKateg;

@Local
public interface BlogKategorijeBeanLocal {
	List<BlogKateg> getKategorije();
}
