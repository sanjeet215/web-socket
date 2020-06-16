package com.asiczen.sockets.publish.message.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class PublichMessage {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	public void publishMessages() {
		
	}
}
