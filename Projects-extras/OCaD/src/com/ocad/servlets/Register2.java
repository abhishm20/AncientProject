package com.ocad.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ocad.dto.UserDTO;
import com.ocad.jdbc.JDBC;
import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class Register2
 */
@WebServlet("/registerUser2")
public class Register2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean check = false;
		HttpSession session = request.getSession(false);
		UserDTO user= (UserDTO) session.getAttribute("part1Data");
		if(null == session.getAttribute("part1Data"))
		{
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry there is some problem");
			response.sendRedirect("error");
			return;
			 
		}
		
		/*Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String filename = getFilename(filePart);
	    InputStrea m filecontent = filePart.getInputStream();*/
	    
		/* user.setDob(request.getParameter("birthDay").trim()+"-"+request.getParameter("birthMonth").trim()+"-"+request.getParameter("birthYear").trim());*/
		user.setDob(request.getParameter("dob")); 
	    user.setMobNo(request.getParameter("mobNo"));
		 user.setAddress(request.getParameter("line1")+
				 " "+request.getParameter("line2")+""+request.getParameter("line3"));
		 user.setState(request.getParameter("state"));
		 user.setCountry(request.getParameter("country"));
		 user.setPinCode(request.getParameter("pinCode"));
		 user.setOccupation(request.getParameter("occupation"));
		 user.setCompanyName(request.getParameter("CompanyName"));
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sendMail");
				dispatcher.forward(request, response);
				return;
		 }
	}

	private String getFilename(Part filePart) {
		// TODO Auto-generated method stub
		return null;
	}


}
