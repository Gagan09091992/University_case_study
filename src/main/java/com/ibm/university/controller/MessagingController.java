package com.ibm.university.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.ibm.university.entity.Greetings;
import com.ibm.university.entity.Messengers;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/restservices/")
public class MessagingController {
	
	@GetMapping

	@MessageMapping("/hello")
	@SendTo("/chatbox/greetings")
	public Greetings greeting(Messengers message) throws Exception {
		Thread.sleep(1000);
		return new Greetings("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}
