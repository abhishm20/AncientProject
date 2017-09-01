package com.canteen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canteen.dto.OrderDTO;
import com.canteen.jdbc.JDBC;

/**
 * 
 * @author aditya
 *
 */
@WebServlet("/order")
public class CurrentOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("order").equals("Refresh")) {
			RequestDispatcher rd;
			try {
				List<OrderDTO> orderList = JDBC.getAllOrders();
				if (orderList.size() == 0) {
					request.setAttribute("message","No orders found so far.. Please review here again later..");
					rd = request.getRequestDispatcher("allorders.jsp");
					rd.forward(request, response);
					return;
				} else {
					System.out.println(orderList);
					request.setAttribute("orders", orderList);
					rd = request.getRequestDispatcher("allorders.jsp");
					rd.forward(request, response);
					return;
				}
			} catch (ClassNotFoundException e) {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}
		} else if (request.getParameter("order").equals("Handle Orders")) {
			String[] chcString = request.getParameterValues("delete");
			RequestDispatcher rd;
			if (chcString == null || chcString.length == 0) {
				List<OrderDTO> orderList = null;
				try {
					orderList = JDBC.getAllOrders();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("message","You don't have any order to delete..");
				request.setAttribute("orders", orderList);
				rd = request.getRequestDispatcher("allorders.jsp");
				rd.forward(request, response);
				return;
			} else {
				try {
					boolean isDone = JDBC.deleteOrders(chcString);
					if (isDone) {
						request.setAttribute("message","Orders have been updated");
						rd = request.getRequestDispatcher("allorders.jsp");
						rd.forward(request, response);
						return;
					} else {

					}
				} catch (ClassNotFoundException e) {
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				} catch (SQLException e) {
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					return;
				}
			}
		}
	}
}
