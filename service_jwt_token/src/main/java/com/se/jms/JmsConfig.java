package com.se.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    connectionFactory.setTrustAllPackages(true);
	    return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    template.setMessageConverter(jacksonJmsMessageConverter());
	    template.setPubSubDomain(false);
	    return template;
	}
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setConcurrency("1-1");
	    factory.setPubSubDomain(false);
	    return factory;
	}
	
	@Bean	//Ham tao ket noi va send data => factory
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
//	@Bean	//Ham chuyen doi POJO => JSON
//	public MessageConverter jacksonJmsConverter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter . setTargetType(MessageType.TEXT);
//		converter . setTypeIdPropertyName("_type");
//		return converter;
//	}

}