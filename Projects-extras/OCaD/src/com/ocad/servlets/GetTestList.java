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

import com.ocad.dto.TestListDTO;
import com.ocad.jdbc.JDBC;

/**
 * Servlet implementation class GetTestList
 */
@WebServlet("/test")
public class GetTestList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TestListDTO> testList = new ArrayList<TestListDTO>();
		
		try {
			testList = JDBC.getTestList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there is some problem "+e);
			response.sendRedirect("error");
			return;
		}
		if(null == testList)
		{
			this.getServletConfig().getServletContext().setAttribute("message", "Sorry, there is some problem ");
			response.sendRedirect("error");
			return;
		}
		else
		{
			System.out.println(testList.toString());
			request.setAttribute("testList", testList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("testPage");
			dispatcher.forward(request, response);
			return;
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
