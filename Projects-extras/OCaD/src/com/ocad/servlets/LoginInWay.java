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
 * Servlet implementation class LoginInWay
 */
@WebServlet("/log_in")
public class LoginInWay extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO user = new UserDTO();
		HttpSession session = request.getSession(false);
		String testId = (String) session.getAttribute("testId");
		String userId = request.getParameter("userId").trim();
		String password = request.getParameter("password").trim();
	
		if(!"".equalsIgnoreCase(userId)  && !"".equalsIgnoreCase(password))
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
					 session = request.getSession(true);
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
				response.sendRedirect((response.encodeRedirectURL("prepareTest?id="+testId+"&user="+EncoderDecoder.encode(user.getUserId()))));
				return;
				
			}
			}
		else if("not activated".equalsIgnoreCase(result))
		{System.out.println("6remeber me yes");
			request.setAttribute("loginPage", "\tYour account is not confirmed ...! please confirm     <a href=\"sendMail\">click here to resend confirmation mail</a> \n\n");
			RequestDispatcher dispatcher = request.getRequestDispatcher("detailsForTest");
			dispatcher.forward(request, response);
			return;
			}
		else
		{System.out.println("7remeber me yes");
			request.setAttribute("loginPage", "\tYou entered wrong details ...! please re-enter \n\n");
			RequestDispatcher dispatcher = request.getRequestDispatcher("detailsForTest");
			dispatcher.forward(request, response);
			return;
			}
		
	}
	}

}
