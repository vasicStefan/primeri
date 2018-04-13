package beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.Conference;

/**
 * Message-Driven Bean implementation class for: FranceMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/topic/konfTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jms/topic/konfTopic")
public class FranceMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public FranceMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
			ObjectMessage om = (ObjectMessage) message;
			Conference c = (Conference) om.getObject();
			if(c.getCountry().equals("Francuska")) {
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

}
