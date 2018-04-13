package beans;

import javax.ejb.Remote;

import model.Conference;

@Remote
public interface KonfBeanRemote {
	public void sendToQueue(Conference c);
}
