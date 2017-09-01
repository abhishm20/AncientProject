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
 * Servlet implementation class Login
 */
@WebServlet("/loginUser")

public class Login extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("remeber me yes");
			
	}

	
	//@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rememberMe ="";
		UserDTO user = new UserDTO();
		String userId = request.getParameter("userId").trim();
		String password = request.getParameter("password").trim();
		boolean remStatus = request.getParameter("rememberMe") != null;
		if(remStatus == true)
		{
			//System.out.println("remeber me yes");
		 rememberMe = request.getParameter("rememberMe").trim();
		}
		else 
		{
			System.out.println("remeber me no");
			 rememberMe = "";
		}
		if(!"".equalsIgnoreCase(userId)  || !"".equalsIgnoreCase(password))
		{
			System.out.println("2remeber me yes");
			String result="";
			try {
				result = JDBC.checkLogin(userId, password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error");
				return;

			}
			if("success".equalsIgnoreCase(result))
			{
				
				System.out.println("3remeber me yes");
		
				if("rememberMe".equalsIgnoreCase(rememberMe))
				{//System.out.println("5remeber me yes");
					System.out.println("remember me is on");
					String cookieValue;
					try {
						cookieValue = JDBC.getUserId(userId);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
						response.sendRedirect("error");
						return;
					}
					if(!"null".equals(cookieValue))
					{System.out.println("here3");
						Cookie cookie = new Cookie("UninetUserCookie", EncoderDecoder.encode(cookieValue.trim()));
						cookie.setHttpOnly(true);
						//cookie.setSecure(true);
						cookie.setMaxAge(60*60*24*30);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				
				}System.out.println("here8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("redirectToProfile");
				dispatcher.forward(request, response);
				return;
				
		}
		else if("not activated".equalsIgnoreCase(result))
		{System.out.println("6remeber me yes");
			request.setAttribute("loginPage", "\tYour account is not confirmed ...! please confirm     <a href=\"sendMail\">click here to resend confirmation mail</a> \n\n");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login");
			dispatcher.forward(request, response);
			return;
			}
		else
		{System.out.println("7remeber me yes");
			request.setAttribute("loginPage", "\tYou entered wrong details ...! please re-enter \n\n");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login");
			dispatcher.forward(request, response);
			return;
			}
		
	}

		
}



}
