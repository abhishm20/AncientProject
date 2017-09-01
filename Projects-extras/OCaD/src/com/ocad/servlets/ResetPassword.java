package com.ocad.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocad.dto.UserDTO;
import com.ocad.jdbc.JDBC;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId= request.getParameter("userId");
		UserDTO user = new UserDTO();
		boolean  matched = false;
		boolean check = false;
		
		try {
			check = JDBC.checkEntryByUserId(userId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
			response.sendRedirect("error");
			return;
		}
		if(check == true)
		{
			try {
				check = JDBC.checkEntryByEmailId(userId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error");
				return;
			}
			if(check == true)
			{
				matched = false;
				
			}
			else
			{
				matched = true;
			}
		}
		else
		{
			matched = true;
			
		}
		if(true == matched)
		{
		try {
			user = JDBC.extractUserDetailsByUserId(userId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
			response.sendRedirect("error");
			return;
		}
		if(null == user)
		{
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry there is some problem !!!");
			response.sendRedirect("error");
			return;
			
		}
		else
		{
			request.setAttribute("username", user.getUsername());
			request.setAttribute("userId", user.getUserId());
			request.setAttribute("securityQue", user.getSecurityQue());
			request.setAttribute("securityAns", user.getSecurityAns());
			RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword");
			dispatcher.forward(request, response);
			return;
		}
		}
		else
		{
			request.setAttribute("forgotPasswordPage", "Sorry this ID is not registered !!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword");
			dispatcher.forward(request, response);
			return;
		}
	}
}
