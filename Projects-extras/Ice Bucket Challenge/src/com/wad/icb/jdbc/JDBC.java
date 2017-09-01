package com.wad.icb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.wad.icb.dao.PersonDTO;
import com.wad.icb.util.SortPerson;


public class JDBC {

	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Class.forName("com.mysql.jdbc.Driver");
		String url = rb.getString("dburl");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		// Connection
		// con=DriverManager.getConnection("jdbc:mysql://localhost:8888/practice1","root","root");
		Connection con = DriverManager.getConnection(url, userid, password);

		if (con != null) {
			System.out.println("connection ready.....");

		} else {
			System.out.println("connecion cnanot be made");
		}

		return con;

	}
	
	public static ArrayList<PersonDTO> getData(int pageNo) throws ClassNotFoundException, SQLException
	{
		PersonDTO person = null;
		ArrayList<PersonDTO> personList = new ArrayList<PersonDTO>();
		int first = (8*(pageNo - 1))+1;
		int last = 8*pageNo;
		System.out.println("first "+first);
		System.out.println("last "+last);
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;
		try{
			connection = getConnection();
			query = connection.prepareStatement("select id, name, donated, url from person having id >= ? and id <= ?;");
			query.setInt(1, first);
			query.setInt(2, last);
			result = query.executeQuery();
			if(result.next())
			{
				do
				{
					person = new PersonDTO();
					person.setId(result.getInt("id"));
					person.setName(result.getString("name").trim());
					person.setUrl(result.getString("url").trim());
					person.setDonated(result.getDouble("donated"));
					personList.add(person);
				}while(result.next());
				Collections.sort(personList,new SortPerson());
				return personList;
			}
			return null;
		}
		finally{
			if(result != null)
			{
				result.close();
			}
			if(query != null)
			{
				query.close();
			}
			if(connection != null)
			{
				connection.close();
			}
			
		}
	}
}
