package com.ocad.mail;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;

import com.sun.xml.internal.bind.CycleRecoverable.Context;




public class SendMailTLS {
 
	public static void main(String[] args) {
		
		/**
		 * Servlet implementation class SendMailServlet
		 */
		
				
				String toAdrress ="abhishekshm007@gmail.com";
				String encodedId ="hello";
				final String mailId = "abhishekshm007@gmail.com";
				final String password = "sm1ongate";
			
			

			Properties props = new Properties();
			 props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailId, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(mailId));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toAdrress));
				message.setSubject("UNINET : Please confirm your account !!!");
				message.setText("UNINET account confirmation\n\n\n"
						+"Hi "+"\n\n"
						+"You just created account at uninet. Please follow this link to confirm that this is your e-mail address.\n\n"
						+""+"/confirm_email?id="+"\n\n"
						+"Thanks, The Uninet Team");

				Transport.send(message);
				
				
				System.out.println("Done");
				return;
			} catch (MessagingException e) {
				System.out.println(e);
			}

		}
		
}