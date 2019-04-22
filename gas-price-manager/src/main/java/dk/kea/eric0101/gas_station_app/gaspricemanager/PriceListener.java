package dk.kea.eric0101.gas_station_app.gaspricemanager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Destination;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.jms.core.JmsTemplate;


@Component
public class PriceListener {
	private JmsTemplate jmsTemplate;
	private Destination destination;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@JmsListener(destination = "oil.price.queue")
	private void receiveMessage(Message message) {
		if (message instanceof ObjectMessage) {
			try {
				System.out.println(((ObjectMessage) message).getObject());
			}
			catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		}
		else {
			throw new IllegalArgumentException("Message must be of type ObjectMessage");
		}
	//}
		//ObjectMessage message = (ObjectMessage) jmsTemplate.receive(destination);
		//Object messageContent = message.getObject();


		//System.out.println("The new oil price received from the messagequeue was: $" + messageContent + "!");
		//PriceManager.gasPrice = messageContent * (1 + PriceManager.profitMargin);
		//System.out.println("Our new gas price is $" + PriceManager.gasPrice);
	}
}
