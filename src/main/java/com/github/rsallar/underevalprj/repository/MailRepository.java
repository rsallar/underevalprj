package com.github.rsallar.underevalprj.repository;

import javax.mail.Message.RecipientType;

import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.stereotype.Component;

@Component
public class MailRepository {
	
	private static final String YOUR_GMAIL_ADDRESS = "provamailuser@gmail.com";
	private static final String YOUR_GMAIL_PASSWORD = "provamailuserprovamailuser"; //insecure
	
	private static final ServerConfig serverConfigSMTP = new ServerConfig("smtp.gmail.com", 25, YOUR_GMAIL_ADDRESS, YOUR_GMAIL_PASSWORD);
	//private static final ServerConfig serverConfigTLS = new ServerConfig("smtp.gmail.com", 587, YOUR_GMAIL_ADDRESS, YOUR_GMAIL_PASSWORD);
	//private static final ServerConfig serverConfigSSL = new ServerConfig("smtp.gmail.com", 465, YOUR_GMAIL_ADDRESS, YOUR_GMAIL_PASSWORD);
	
	public void sendEmail(String to, String from, String text, String html, String subject){
		
		final Email email = new Email();
		email.setFromAddress(from, from);
		email.addRecipient(to, to, RecipientType.TO);
		email.setText(text);
		email.setTextHTML(html);
		email.setSubject(subject);
		
		sendMail(email);
	}
	
	private static void sendMail(final Email email) {
		// ProxyConfig proxyconfig = new ProxyConfig("localhost", 1030);
		new Mailer(serverConfigSMTP, TransportStrategy.SMTP_TLS).sendMail(email);
		//new Mailer(serverConfigTLS, TransportStrategy.SMTP_TLS).sendMail(email);
		//new Mailer(serverConfigSSL, TransportStrategy.SMTP_SSL).sendMail(email);
	}

}
