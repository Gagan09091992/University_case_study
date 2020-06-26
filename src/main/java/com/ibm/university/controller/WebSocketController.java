package com.ibm.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.ibm.university.entity.MessengersDetails;

@Controller
public class WebSocketController {

	private final SimpMessagingTemplate template;

	@Autowired
	WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping("/send/message")
	public void onReceivedMesage(MessengersDetails message) {
		this.template.convertAndSend("/chatbox",  message);
	}
}