package dk.kea.eric0101.oil_distributor.oilpriceannouncer;

import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

	@Value("${activemq.broker-url}")
	private String brokerURL;

	/*
	 * @Bean public Queue queue() { return new ActiveMQQueue("oil.price.queue"); }
	 */

	@Bean
	Topic topic() {
		return new ActiveMQTopic("oil.price.topic");
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		return factory;
	}

	/**
	 * The JMS template is set up so that we may push messages to the specified
	 * MessageBroker.
	 * 
	 * @return
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
