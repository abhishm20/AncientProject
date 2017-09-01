package com.ocad.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession(false);
		session.invalidate();
		String cookieName;
		String cookieValue;
		Cookie[] cookie = request.getCookies();
		for(Cookie c : cookie)
		{System.out.println("just try");
			cookieName =  c.getName().trim();
			cookieValue = c.getValue().trim();
			//System.out.println(cookieValue);
			//int length = cookieValue.length();
			//System.out.println(length);
			
			//cookieValue = cookieValue.substring(1, length);
			String userId = EncoderDecoder.decode(cookieValue);
			if("UninetUserCookie".equalsIgnoreCase(cookieName))
			{
				c.setMaxAge(1);
			}
			else
			{
				///response.sendRedirect("/test_discussion_project/login.jsp");
				System.out.println("you dont have our coomkie");
				
				
			}
		}
		response.sendRedirect("");
		
		
	}

}
