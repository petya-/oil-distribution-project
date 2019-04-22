package dk.kea.eric0101.oil_distributor.oilpriceannouncer;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priceannouncer")
public class PriceAnnouncer {

	private final double BASE_PRICE = 50d;
	private final Random random = new Random();

	@Autowired
	JmsTemplate jmsTemplate;

	// create queue on startup.
	@Autowired
	Queue queue;

	@GetMapping("/newprice")
	public PriceMessage changePrice() {
		double newPriceMessage = BASE_PRICE + (random.nextDouble() * 25); // Prices range from 50 to 75
		Date now = new Date();
		PriceMessage message = new PriceMessage(newPriceMessage, now);

		jmsTemplate.send(queue, session -> session.createObjectMessage((Serializable) message));
		// publish message to ActiveMQQqueue/topic

		//jmsTemplate.convertAndSend(queue, newPriceMessage);
		//return newPriceMessage;
		return message;
	}

	@GetMapping("/newprice/{randomizerrange}")
	public double priceChange(@PathVariable("randomizerrange") final String ranRange) {
		double newPriceMessage = random.nextDouble() * Double.parseDouble(ranRange);

		// publish message to ActiveMQQqueue/topic
		jmsTemplate.convertAndSend(queue, newPriceMessage);

		return newPriceMessage;
	}

}
