package com.lib.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dto.MemberDTO;
import com.lib.jdbc.JDBC;
@WebServlet("/member")
public class MemberProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userid = (String) request.getAttribute("user");
		request.setAttribute("user", userid);
		session.setAttribute("user", userid);
		try {
			
			MemberDTO memberDTO = JDBC.memberInfo(userid);
			System.out.println(memberDTO.getBranch());
			
			request.setAttribute("name", memberDTO.getName());
			request.setAttribute("id", memberDTO.getMem_id());
			request.setAttribute("branch", memberDTO.getBranch());
			request.getRequestDispatcher("member.jsp").forward(request,
					response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
