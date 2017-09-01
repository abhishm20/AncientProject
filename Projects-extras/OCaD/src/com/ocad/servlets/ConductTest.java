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

import com.ocad.dto.TestDTO;
import com.ocad.jdbc.JDBC;
import com.ocad.security.EncoderDecoder;

/**
 * Servlet implementation class ConductTest
 */
@WebServlet("/conductTest")
public class ConductTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testId = request.getParameter("id");
		System.out.println(testId);
		HttpSession session = request.getSession(false);
		try
		{
			if(null != session.getAttribute("userId"))
			{System.out.println("hello1");
			session.setAttribute("testId", testId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("test.pro");
			dispatcher.forward(request, response);
			return;
			}
			else
			{
				session = request.getSession(true);
				session.setAttribute("testId", testId);
				System.out.println("hello2");
				RequestDispatcher dispatcher = request.getRequestDispatcher("detailsForTest");
				dispatcher.forward(request, response);
				return;
			}
		}
		catch(Exception e)
		{
			session = request.getSession(true);
			session.setAttribute("testId", testId);
			System.out.println("hello3");
			RequestDispatcher dispatcher = request.getRequestDispatcher("detailsForTest");
			dispatcher.forward(request, response);
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
