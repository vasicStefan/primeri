package beans;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import model.Conference;

@Remote
@WebService
public interface KonfWebRemote {
	public List<Conference> getKonferencije(String field);
}
