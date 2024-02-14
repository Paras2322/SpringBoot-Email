package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.email.service.MailServiceWithAttachment;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class MailDemoApplication {

	@Autowired
	private MailServiceWithAttachment mailServiceWithAttachment;

	public static void main(String[] args) {
		SpringApplication.run(MailDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException
	{
		mailServiceWithAttachment.sendMail("parasbagga23@gmail.com", "This is Mail Body", "Spring Boot Email with attachment", "C:/Users/ram/Downloads/Paras sir.png");
	}
}
