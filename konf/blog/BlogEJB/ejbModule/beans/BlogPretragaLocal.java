package beans;

import java.util.List;

import javax.ejb.Local;

import model.Blog;

@Local
public interface BlogPretragaLocal {

	List<Blog> pretrazi(String text);
	
}
