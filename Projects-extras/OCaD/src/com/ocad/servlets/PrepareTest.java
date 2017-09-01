package com.ocad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocad.jdbc.JDBC;
import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class PrepareTest
 */
@WebServlet("/prepareTest")
public class PrepareTest extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String testId = (String) session.getAttribute("testId");
		
		try
		{
			if(null!= session.getAttribute("userId"))
			{
				
				response.sendRedirect(response.encodeURL("startTest?id="+testId+"&user="+EncoderDecoder.decode((String) session.getAttribute("userId"))));
				return;
			}
			else
			{
				
				session = request.getSession(true);
				session.setAttribute("guest", "Guest");
				response.sendRedirect(response.encodeURL("startTest?id="+testId+"&user=guest"));
				return;
				
			}
		}
		catch(Exception e)
		{
			session = request.getSession(true);
			session.setAttribute("guest", "Guest");
			response.sendRedirect(response.encodeURL("startTest?id="+testId+"&user=guest"));
			return;
		}
		
		 /*JDBC.extractQuestions(testId);
		 
		 if(null != session.getAttribute("UserId"))
		 {
			 
		 }
		 {
			 
		 }*/
	}

}
