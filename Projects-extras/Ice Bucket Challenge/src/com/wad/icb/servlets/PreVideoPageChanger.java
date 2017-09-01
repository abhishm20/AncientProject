package com.wad.icb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wad.icb.dao.PersonDTO;
import com.wad.icb.jdbc.JDBC;

/**
 * Servlet implementation class VideoPageChanger
 */
@WebServlet("/ppage.icb")
public class PreVideoPageChanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreVideoPageChanger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ArrayList<PersonDTO> personList = new ArrayList<PersonDTO>();
		System.out.println("percfdsfjk ");
		int page = Integer.parseInt(session.getAttribute("page").toString());
		if(page == 1)
		{
			try {
				personList = JDBC.getData(1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("error occured "+e);
			}
			request.setAttribute("personList", personList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			return;
		}
		System.out.println("prev "+page);
		
		try {
			personList = JDBC.getData(--page);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error occured "+e);
		}
		session.setAttribute("page", ""+page);
		request.setAttribute("personList", personList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
