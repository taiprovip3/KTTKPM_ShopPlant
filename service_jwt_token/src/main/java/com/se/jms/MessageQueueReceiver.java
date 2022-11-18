package com.se.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.se.entity.User;


@Component
public class MessageQueueReceiver {
	
	
//	@JmsListener(destination = "inbound.queue")
//	@SendTo("outbound.queue")
//	public void receiveMessageFromQueueApache(User user) {
//		System.out.println("\n\nListening from queue -> " + user + "\n\n");
//	}
//	
//	@JmsListener(destination = "inbound.topic")
//	@SendTo("outbound.topic")
//	public void receiveMessageFromTopicApache(User user) {
//		System.out.println("\n\nListening from topic -> " + user + "\n\n");
//	}

}
