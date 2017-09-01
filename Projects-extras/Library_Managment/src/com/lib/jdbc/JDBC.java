package com.lib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.lib.dto.BookInfoDTO;
import com.lib.dto.MemberDTO;

public class JDBC {
	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		Class.forName(driverName);
		System.out.println("Driver Loaded...");
		String url = rb.getString("dburl");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(url, userid, password);
		if (con != null) {
			System.out.println("Connection Ready...");
		}
		return con;
	}

	public static boolean checkLogin(String userid, String password)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// Step -3 Query
			stmt = con.createStatement();
			// Step -4 Result
			// select userid,password from user where userid='amit' and
			// password='123'
			rs = stmt.executeQuery("select id,password from login where id='"
					+ userid + "' and password='" + password + "'");
			if (rs.next()) {
				result = true;
				/*
				 * result = "Userid "+ rs.getString("userid")+"  Password "+
				 * rs.getString("password");
				 */
			}
		}

		finally {
			// Step -5 Close the resources
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return result;

	}

	public static MemberDTO memberInfo(String userid)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member where id='" + userid
					+ "'");
			rs.next();
			memberDTO = new MemberDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setBranch(rs.getString("branch"));
			memberDTO.setMem_id(rs.getString("id"));
			System.out.println(memberDTO.getBranch());
			return memberDTO;
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static List<String> foundBooks(String userid)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> bookId = new ArrayList<>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			System.out.println(userid);
			rs = stmt.executeQuery("select * from num_book where id='" + userid
					+ "'");
			while (rs.next()) {
				bookId.add(rs.getString("book_id"));
				System.out.println("Testing");
				System.out.println(rs.getString("book_id"));
			}
			return bookId;
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	public static ArrayList<BookInfoDTO> bookInfo(String userid)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookInfoDTO> bookInfoList = new ArrayList<>();
		BookInfoDTO bookInfoDTO = null;
		List<String> bookId = foundBooks(userid);
		try {
			con = getConnection();
			stmt = con.createStatement();
			while (!bookId.isEmpty()) {
				rs = stmt
						.executeQuery("select * from book_table where book_id='"
								+ bookId.get(0) + "'");
				rs.next();
				bookInfoDTO = new BookInfoDTO();
				bookInfoDTO.setBook_name(rs.getString("book_name"));
				bookInfoDTO.setBook_id(rs.getString("book_id"));
				bookInfoDTO.setFine(rs.getDouble("fine"));
				bookInfoDTO.setIssue_date(rs.getString("issue_date"));
				bookInfoList.add(bookInfoDTO);
				bookId.remove(0);
			}
			return bookInfoList;
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

}
