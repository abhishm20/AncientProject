package com.ocad.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocad.dto.UserDTO;
import com.ocad.jdbc.JDBC;
import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class Home
 */
@WebServlet("/checkCookie")
public class CheckCookie extends HttpServlet {
	
	//@Override
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO user = new UserDTO();
		String cookieName="";
		String cookieValue="";
		Cookie cookie[] = request.getCookies();
		System.out.println("1you dont have cookie");
		if( null == cookie)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
			return;
			//System.out.println("2you dont have cookie");
			
		}
		else 
		{
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
					request.setAttribute("userId", userId);
					System.out.println(userId);
					RequestDispatcher dispatcher = request.getRequestDispatcher("redirectToProfile");
					dispatcher.forward(request, response);
					return;
				}
				else
				{
					///response.sendRedirect("/test_discussion_project/login.jsp");
					System.out.println("you dont have our coomkie");
					
					
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
			return;
			
		}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("you dont have cookie");
	}

}
