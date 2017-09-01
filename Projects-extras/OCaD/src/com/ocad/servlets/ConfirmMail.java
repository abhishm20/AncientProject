package com.ocad.servlets;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class ConfirmMail
 */
@WebServlet("/confirm_email")
public class ConfirmMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		System.out.println("helloooo"+i++);
		UserDTO user = new UserDTO();
		String queryString = request.getQueryString();
		String encodedId = queryString.substring(3);
		System.out.println(encodedId);
		boolean result = false;
		try {
			result = JDBC.confirmMail(encodedId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(true == result)
		{System.out.println("helloooo"+i++);
			try {
				user = JDBC.extractUserDetailsByUserId(EncoderDecoder.decode(encodedId));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error.jsp");
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error.jsp");
				return;
			}
			if(null == user)
			{System.out.println("4remeber me yes");
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error ");
				response.sendRedirect("error.jsp");
				return;
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
			System.out.println("good");
			response.sendRedirect("profile");
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
