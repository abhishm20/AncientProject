package com.ocad.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocad.dto.AttemptedTestDTO;
import com.ocad.dto.TestListDTO;
import com.ocad.jdbc.JDBC;

/**
 * Servlet implementation class TestList
 */
@WebServlet("/TestList")
public class TestList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AttemptedTestDTO> attemptedTestList = new ArrayList<AttemptedTestDTO>();
		ArrayList<TestListDTO> testList = new ArrayList<TestListDTO>();
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		
		try {
			attemptedTestList = JDBC.getAttemptedTests(userId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry there were a problem"+e);
			response.sendRedirect("error");
			return;
		}
		if(null == attemptedTestList)
		{
			session.setAttribute("noTest", "YOu have not given any test till now...");
		}
		{
			try {
				testList = JDBC.getTestList();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry there were a problem"+e);
				response.sendRedirect("error");
				return;
			}
			if(null == testList)
			{
				this.getServletConfig().getServletContext().setAttribute("message", "Sorry there were a problem");
				response.sendRedirect("error");
				return;
			}
			else
			{
				request.setAttribute("testList", testList);
				request.setAttribute("attemptedTestList", attemptedTestList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("test");
				dispatcher.forward(request, response);
				return;
				
			}
		}
	}

}
