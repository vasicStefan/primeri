package beans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

import model.Conference;

/**
 * Session Bean implementation class KonfBean
 */
@Stateless
@LocalBean
public class KonfBean implements KonfBeanRemote {

	@Inject
	JMSContext jmsContext;
	
	@Resource(mappedName="java:/jms/queue/konf")
	Destination destination;
	
    /**
     * Default constructor. 
     */
    public KonfBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sendToQueue(Conference c) {
		jmsContext.createProducer().send(destination, c);
		
	}

}
