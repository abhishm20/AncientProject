package com.ocad.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocad.dto.UserDTO;
import com.ocad.jdbc.JDBC;
import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registerUser")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = null;
		boolean check = false;
		HttpSession session = request.getSession(true);
		UserDTO user= new UserDTO();
		 user.setUserId(request.getParameter("userId").trim());
		 user.setEmailId(request.getParameter("emailId").trim());
		 user.setPassword(request.getParameter("password").trim());
		 user.setFname(request.getParameter("Fname").trim());
		 user.setMname(request.getParameter("Mname").trim());
		 user.setLname(request.getParameter("Lname").trim());
		 user.setGender(request.getParameter("gender"));
		 user.setSecurityAns(request.getParameter("securityAns"));
		 user.setSecurityQue(request.getParameter("securityQue"));
		 user.setUsername(user.getFname()+" "+user.getMname()+" "+user.getLname());
		 
		 try {
			check = JDBC.checkEntryByUserId(user.getUserId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
			response.sendRedirect("error");
			return;
		}
		 if(false == check)
		 {
			 request.setAttribute("alreadyExist", "Sorry this user-id is already registered !!!");
			 dispatcher = request.getRequestDispatcher("register");
			 dispatcher.forward(request, response);
			 return;
		 }
		 else if(true == check)
		 {
			 try {
				check = JDBC.checkEntryByEmailId(user.getEmailId());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t"+e);
				response.sendRedirect("error");
				return;
			}
			 if(false == check)
			 {
				 request.setAttribute("alreadyExist", "Sorry this email-id is already registered !!!");
				 dispatcher = request.getRequestDispatcher("register");
				 dispatcher.forward(request, response);
				 return;
			 }
			 else if(true == check)
			 {
				 try {
						check = JDBC.addNewUser(user);
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
					 if(true != check)
					 {
						 this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there were an error \t");
							response.sendRedirect("error");
							return;
					 }
					 else if(true == check)
					 {
						 System.out.println("success");
						session = request.getSession(true);
						session.setMaxInactiveInterval(1800);
							//session.setAttribute("userId", user.getUserId());
							//user.setUsername(user.getFname()+" "+user.getMname()+" "+user.getLname());
							session.setAttribute("username", user.getUsername());
							//session.setAttribute("address", user.getAddress());
							//session.setAttribute("mobNo", user.getMobNo());*/
							session.setAttribute("emailId", user.getEmailId());
							session.setAttribute("encodedId", EncoderDecoder.encode(user.getUserId()));
							/*session.setAttribute("password", user.getPassword());
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
							session.setAttribute("pinCode", user.getPinCode());*/
						 //this.getServletConfig().getServletContext().setAttribute("email", "");
							System.out.println("done2");
							 dispatcher = request.getRequestDispatcher("/sendMail");
							dispatcher.forward(request, response);
							return;
					 }
			 }
		 }
		 
	}

}


