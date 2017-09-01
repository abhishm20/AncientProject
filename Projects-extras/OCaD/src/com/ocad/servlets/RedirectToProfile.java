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
 * Servlet implementation class RedirectToProfile
 */
@WebServlet("/redirectToProfile")
public class RedirectToProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDTO user = new UserDTO();
		System.out.println("3   remeber me yes");
		try {
			user = JDBC.extractUserDetailsByUserId(userId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
			response.sendRedirect("error");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
			response.sendRedirect("error");
			return;
		}
		if(null == user)
		{
			try {
				user = JDBC.extractUserDetailsByEmailId(userId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error");
				return;
				
			}
			if(null == user)
			{
			System.out.println("4remeber me yes");System.out.println(userId);
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error ");
			response.sendRedirect("error");
			return;
			}
			else
			{
				System.out.println("You are redirecting to your profile....");
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", user.getUserId());
				user.setUsername(user.getFname()+" "+user.getMname()+" "+user.getLname());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("mobNo", user.getMobNo());
				session.setAttribute("emailId", user.getEmailId());
				session.setAttribute("password", user.getPassword());
				session.setAttribute("gender", user.getGender());
				session.setAttribute("occupation", user.getOccupation());
				session.setAttribute("state", user.getState());
				session.setAttribute("city", user.getCity());
				session.setAttribute("mobNo", user.getMobNo());
				session.setAttribute("country", user.getCountry());
				session.setAttribute("Fname", user.getFname());
				session.setAttribute("Mname", user.getMname());
				session.setAttribute("Lname", user.getLname());
				session.setAttribute("dob", user.getDob());
				session.setAttribute("companyName", user.getCompanyName());
				session.setAttribute("securityQue", user.getSecurityQue());
				session.setAttribute("securityAns", user.getSecurityAns());
				session.setAttribute("pinCode", user.getPinCode());
				response.sendRedirect("profile");
				return;
			}
		}
		System.out.println("You are redirecting to your profile....");
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", user.getUserId());
		user.setUsername(user.getFname()+" "+user.getMname()+" "+user.getLname());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("address", user.getAddress());
		session.setAttribute("mobNo", user.getMobNo());
		session.setAttribute("emailId", user.getEmailId());
		session.setAttribute("password", user.getPassword());
		session.setAttribute("gender", user.getGender());
		session.setAttribute("occupation", user.getOccupation());
		session.setAttribute("state", user.getState());
		session.setAttribute("city", user.getCity());
		session.setAttribute("mobNo", user.getMobNo());
		session.setAttribute("country", user.getCountry());
		session.setAttribute("Fname", user.getFname());
		session.setAttribute("Mname", user.getMname());
		session.setAttribute("Lname", user.getLname());
		session.setAttribute("dob", user.getDob());
		session.setAttribute("companyName", user.getCompanyName());
		session.setAttribute("securityQue", user.getSecurityQue());
		session.setAttribute("securityAns", user.getSecurityAns());
		session.setAttribute("pinCode", user.getPinCode());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
		dispatcher.forward(request, response);
		return;
			
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
