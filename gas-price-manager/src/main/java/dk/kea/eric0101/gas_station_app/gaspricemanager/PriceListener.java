package dk.kea.eric0101.gas_station_app.gaspricemanager;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PriceListener {

	@JmsListener(destination = "oil.price.topic")
	private void receiveMessage(double oilPriceChange) throws JMSException {
		System.out.println("The new oil price received from the messagequeue was: $" + oilPriceChange + "!");
		PriceManager.gasPrice = oilPriceChange * (1 + PriceManager.profitMargin);
		System.out.println("Our new gas price is $" + PriceManager.gasPrice);
	}
}
