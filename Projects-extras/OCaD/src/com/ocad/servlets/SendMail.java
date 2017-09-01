package com.ocad.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/sendMail")
public class SendMail extends HttpServlet {
	

	String domain;
	String mailId;
	String mailPassword;
	
	@Override
	public void init() throws ServletException {
		ResourceBundle bundle = ResourceBundle.getBundle("parameters");
		domain = bundle.getString("domain");
		mailId = bundle.getString("mailId");
		mailPassword = bundle.getString("mailPassword");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String toAdrress ="";
		String encodedId ="";
		HttpSession sessionC = request.getSession(false);
		if(!"null".equals(sessionC.getAttribute("emailId")) || !"null".equals(sessionC.getAttribute("encodedId")))
		{
		 toAdrress = (String) sessionC.getAttribute("emailId");
		 encodedId = (String) sessionC.getAttribute("encodedId");
		}
		else
		{
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t");
			response.sendRedirect("error.jsp");
			return;
		}
	

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(mailId, mailPassword);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailId));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toAdrress));
		message.setSubject("OCaD-space : Please confirm your account !!!");
		message.setText("OCaD-space account confirmation\n\n\n"
				+"Hi "+sessionC.getAttribute("username")+"\n\n"
				+"You just created account at uninet. Please follow this link to confirm that this is your e-mail address.\n\n"
				+""+domain+"/confirm_email?id="+sessionC.getAttribute("encodedId")+"\n\n"
				+"Thanks, The OCaD-space Team");

		Transport.send(message);
		
		if("one".equals(sessionC.getAttribute("mailNo1")))
		{
			sessionC.setAttribute("resendMail", "An email has been Resent !!!");
			sessionC.setAttribute("mailNo", "one");
		}
		else
		{
		sessionC.setAttribute("mailNo1", "one");
		}
		System.out.println("Done");
		response.sendRedirect("confirm");
		return;
	} catch (MessagingException e) {
		this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
		response.sendRedirect("error");
		return;
	}

}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
