package com.asiczen.sockets.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Controller
public class SocketController {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/message")
	@SendToUser("/queue/reply")
	public String processMessageFromClient(@Payload String message, Principal principal) throws Exception {
		String name = new Gson().fromJson(message, Map.class).get("name").toString();
		// messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply",
		// name);
		return name;
	}

	@MessageExceptionHandler
	@SendToUser("/queue/errors")
	public String handleException(Throwable exception) {
		return exception.getMessage();
	}

}
