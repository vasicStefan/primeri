package beans;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import javni.Country;
import javni.CountrySoap;
import model.Conference;

/**
 * Message-Driven Bean implementation class for: KonfMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/konf"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/konf")
public class KonfMDB implements MessageListener {

	@PersistenceContext
	EntityManager em;
	
	@Inject
	JMSContext jmsContext;
	
	@Resource(mappedName="java:/jms/topic/konfTopic")
	Destination destination;
	
	@WebServiceRef(Country.class)
	CountrySoap cs;
	
    /**
     * Default constructor. 
     */
    public KonfMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
			ObjectMessage om = (ObjectMessage) message;
			Conference c = (Conference) om.getObject();
			em.persist(c);
			
			c.setCountryCode(cs.getCountryByCountryCode(c.getCountry()));
			String ime = c.getCountry();
			c.setCountryCode(cs.getCountryByCountryCode(ime));
			c.setCurrency(cs.getCurrencyByCountry(ime));
			c.setDialingCode(cs.getISD(ime));			
			jmsContext.createProducer().send(destination, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

}
