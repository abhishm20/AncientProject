package com.ocad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.ocad.dto.AttemptedTestDTO;
import com.ocad.dto.QuestionDTO;
import com.ocad.dto.TestDTO;
import com.ocad.dto.TestListDTO;
import com.ocad.dto.UserDTO;
import com.ocad.security.EncoderDecoder;

public class JDBC {

	
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle bundle = ResourceBundle.getBundle("parameters");
		String url = bundle.getString("url");
		String driver = bundle.getString("driver");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		if(connection != null)
		{
			return connection;
		}
		return null;
	}
	
	
	public static UserDTO checkCookie(String cookieValue) throws SQLException, ClassNotFoundException
	{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
	getConnection();
	UserDTO userDetails = new UserDTO();
	System.out.println(cookieValue);
	try{
		query = connection.prepareStatement("select userId from login where encodedId = ?;");
		query.setString(1, cookieValue);
		result = query.executeQuery();
		
		if(result.next())
		{
				userDetails = JDBC.extractUserDetailsByUserId(result.getString("userId"));
				if(null != userDetails)
				{
					return userDetails;
				}
				else
				{
					return null;
				}
		} 
			return null;
	}
	finally{
		if(query!=null){
			query.close();
			}
			if(connection!=null){
				connection.close();
			}	
	}
		
}
	
	
	public static String checkLogin(String userId, String password) throws ClassNotFoundException, SQLException
	{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
		connection = getConnection();
		String id ="";
		boolean active = true;
		try{
		query = connection.prepareStatement("select userId, active from login where userId=? and password = ?;");
			query.setString(1, userId);
			query.setString(2, password);
			result = query.executeQuery();
			if(result.next())
			{
				id = result.getString("userId");
				active = result.getBoolean("active");
				if(active == false && id.equals(userId))
				{
					return "not activated";
				}
				else if(active == true && id.equals(userId))
				{
					return "success";					
				}
			}
			System.out.println("hello2014");
			query.close();
			query = connection.prepareStatement("select emailId, active from login where emailId=? and password = ?");
				query.setString(1, userId);
				query.setString(2, password);
				result = query.executeQuery();
				if(result.next())
				{
					id = result.getString("emailId");
					active = result.getBoolean("active");
					if(active == false && id.equals(userId))
					{
						return "not activated";
					}
					else if(active == true && id.equals(userId))
					{
						
						return "success";					
					}
				}
					return "don't have account";
				
		}
			finally{
				if(query!=null){
					query.close();
					}
					if(connection!=null){
						connection.close();
					}	
			}
}
	
		/*else if(!email)
		{
			query = connection.prepareStatement("select roll_no , password from st_login where roll_no = ? and password = ? and status =false;");
			query.setString(1, userId);
			query.setString(2, password);
			result = query.executeQuery();

			while(result.next())
			{
				passwd = result.getString("password");
				username = result.getString("roll_no");
			}
			if(!username.equals("") && !passwd.equals(""))
			{
				query = connection.prepareStatement("update st_login set status = true where roll_no=? and password=?;");
				query.executeUpdate();
				query.setString(1, userId);
				query.setString(2, password);
				return true;
			}
			
		}
		
		return false;*/
	
	public static boolean confirmMail(String encodedId) throws SQLException, ClassNotFoundException
	{
		PreparedStatement query = null;
		Connection connection = null;
		connection = getConnection();
		query = connection.prepareStatement("update login set active = true where userId = ?;");
		query.setString(1, EncoderDecoder.decode(encodedId));
		int result = query.executeUpdate();
		if(result >0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean checkEntryByUserId(String userId) throws ClassNotFoundException, SQLException{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
		try{
			connection = getConnection();
			query = connection.prepareStatement("select userId from login where userId=?;");
			query.setString(1, userId);
		 result = query.executeQuery();
		 if(result.next()){
			 return false; // user id  exist in db
		 }else{
			 return true;
		 }
		}
		 finally{
			 if(query!=null){
				 query.close();
					}
					if(connection!=null){
						connection.close();
					}	
			 }
	}
	
	
	public static boolean checkEntryByEmailId(String emailId) throws ClassNotFoundException, SQLException{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
		try{
			connection = getConnection();
			query = connection.prepareStatement("select userId from login where emailId=?;");
			query.setString(1, emailId);
		 result = query.executeQuery();
		 if(result.next()){
			 return false; // user id  exist in db
		 }else{
			 return true;
		 }
		}
		 finally{
			 if(query!=null){
				 query.close();
					}
					if(connection!=null){
						connection.close();
					}	
			 }
	}
	
	
		 
	public static	UserDTO extractUserDetailsByUserId(String userId) throws ClassNotFoundException, SQLException
		{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
			UserDTO extractedUserDetails = new UserDTO();
			connection = getConnection();
			query = connection.prepareStatement("select userId,Fname, Mname,Lname,emailId,password,gender,address,mobNo,dob,pinCode,city,state,country,occupation,companyName,securityQue,securityAns from user_details where userId=?;");
			query.setString(1, userId);
			result = query.executeQuery();
			if(result.next())
			{
				extractedUserDetails.setUserId(result.getString("userId"));
				extractedUserDetails.setFname(result.getString("Fname"));
				extractedUserDetails.setMname(result.getString("Mname"));
				extractedUserDetails.setLname(result.getString("Lname"));
				extractedUserDetails.setEmailId(result.getString("emailId"));
				extractedUserDetails.setPassword(result.getString("password"));
				extractedUserDetails.setGender(result.getString("gender"));
				extractedUserDetails.setAddress(result.getString("address"));
				extractedUserDetails.setPinCode(result.getString("pinCode"));
				extractedUserDetails.setMobNo(result.getString("mobNo"));
				extractedUserDetails.setDob(result.getString("dob"));
				extractedUserDetails.setCity(result.getString("city"));
				extractedUserDetails.setState(result.getString("state"));
				extractedUserDetails.setCountry(result.getString("country"));
				extractedUserDetails.setCompanyName(result.getString("companyName"));
				extractedUserDetails.setSecurityQue(result.getString("securityQue"));
				extractedUserDetails.setSecurityAns(result.getString("securityAns"));
				extractedUserDetails.setOccupation(result.getString("occupation"));
				return extractedUserDetails;
			}
			else
			{
				return null;
			}
			
		}
	

	public static	UserDTO extractUserDetailsByEmailId(String emailId) throws ClassNotFoundException, SQLException
	{
	PreparedStatement query = null;
	Connection connection = null;
	ResultSet result = null;
		UserDTO extractedUserDetails = new UserDTO();
		connection = getConnection();
		query = connection.prepareStatement("select userId,Fname, Mname,Lname,emailId,password,gender,address,mobNo,dob,pinCode,city,state,country,occupation,companyName,securityQue,securityAns from user_details where emailId=?;");
		query.setString(1, emailId);
		result = query.executeQuery();
		if(result.next())
		{
			extractedUserDetails.setUserId(result.getString("userId"));
			extractedUserDetails.setFname(result.getString("Fname"));
			extractedUserDetails.setMname(result.getString("Mname"));
			extractedUserDetails.setLname(result.getString("Lname"));
			extractedUserDetails.setEmailId(result.getString("emailId"));
			extractedUserDetails.setPassword(result.getString("password"));
			extractedUserDetails.setGender(result.getString("gender"));
			extractedUserDetails.setAddress(result.getString("address"));
			extractedUserDetails.setPinCode(result.getString("pinCode"));
			extractedUserDetails.setMobNo(result.getString("mobNo"));
			extractedUserDetails.setDob(result.getString("dob"));
			extractedUserDetails.setCity(result.getString("city"));
			extractedUserDetails.setState(result.getString("state"));
			extractedUserDetails.setCountry(result.getString("country"));
			extractedUserDetails.setCompanyName(result.getString("companyName"));
			extractedUserDetails.setSecurityQue(result.getString("securityQue"));
			extractedUserDetails.setSecurityAns(result.getString("securityAns"));
			extractedUserDetails.setOccupation(result.getString("occupation"));
			return extractedUserDetails;
		}
		else
		{
			return null;
		}
		
	}
	
	
	
	public static boolean addNewUser(UserDTO user) throws SQLException, ClassNotFoundException{
		PreparedStatement query = null;
		Connection connection = null;
		connection = getConnection();
		int recordCount = 0;
		int recordCount2= 0;
			try{
			
			//connection.setAutoCommit(false);
			query = connection.prepareStatement("insert into user_details (userId,emailId,password,gender,Fname,Mname,Lname,dob,mobNo,address,occupation,companyName,securityQue,securityAns,city,state,country,pinCode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			query.setString(1,user.getUserId());
			query.setString(2,user.getEmailId());
			query.setString(3,user.getPassword());
			query.setString(4,user.getGender());
			query.setString(5,user.getFname());
			query.setString(6,user.getMname());
			query.setString(7,user.getLname());
			query.setString(8,user.getDob());
			query.setString(9,user.getMobNo());
			query.setString(10,user.getAddress());
			query.setString(11,user.getOccupation());
			query.setString(12,user.getCompanyName());
			query.setString(13,user.getSecurityQue());
			query.setString(14,user.getSecurityAns());
			query.setString(15,user.getCity());
			query.setString(16,user.getState());
			query.setString(17,user.getCountry());
			query.setString(18,user.getPinCode());
			recordCount = query.executeUpdate();
			
			query = connection.prepareStatement("insert into login(userId,encodedId,emailId,password,active) values(?,?,?,?,?)");
			query.setString(1,user.getUserId());
			query.setString(2, EncoderDecoder.decode(user.getUserId()));
			query.setString(3,user.getEmailId());
			query.setString(4,user.getPassword());
			query.setBoolean(5, false);
			recordCount2 = query.executeUpdate();
			
			if(recordCount>0 && recordCount2>0){
				//connection.commit();
				return true;
				
			}
			else
			{System.out.println("hello");
				//connection.rollback();
				return false;
			}
		}
		finally{
			if(query!=null){
				query.close();
				}
				if(connection!=null){
					connection.close();
				}	
		}
		
	}
	
	
	public static TestDTO extractTestDetails(String testId) throws ClassNotFoundException, SQLException
	{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
		TestDTO test = new TestDTO();
		test.setTestId(testId);
		try
		{
		connection = getConnection();
		query = connection.prepareStatement("select que_table_id, time, mm, no_of_que from tests where test_id = ?;");
		query.setString(1, testId);
		result = query.executeQuery();
		if(result.next())
		{
			test.setQueId(result.getString("que_table_id"));
			test.setTime(result.getInt("time"));
			test.setMm(result.getInt("mm"));
			test.setQueNo(result.getInt("no_of_que"));
			ArrayList<QuestionDTO> questionDTO = new ArrayList<QuestionDTO>();
			
			if(null == (questionDTO=JDBC.extractQuestions(testId)))
			{
				return null;
			}
			else
			{
				/*test.setTestId(questionDTO);*/
			}
		}
		return null;
	}
		finally{
			if(query!=null){
				query.close();
				}
				if(connection!=null){
					connection.close();
				}	
		}
		
		 
	}
	
	public static ArrayList<QuestionDTO> extractQuestions(String questionId) throws SQLException, ClassNotFoundException
	{
		PreparedStatement query = null;
		Connection connection = null;
		ResultSet result = null;
		QuestionDTO question = null;
		ArrayList<QuestionDTO> questionDTO = new ArrayList<QuestionDTO>();
		
		try
		{
			connection = getConnection();
		query = connection.prepareStatement("select * from "+questionId+";");
		result = query.executeQuery();
		while(result.next())
		{
			question = new QuestionDTO();
			question.setQuestionId(result.getString("que_id"));
			question.setQuestion(result.getString("question"));
			question.setWrong1(result.getString("wrong1"));
			question.setWrong2(result.getString("wrong2"));
			question.setWrong3(result.getString("wrong3"));
			question.setCorrect(result.getString("correct"));
			if(questionDTO.add(question))
			{
				continue;
			}
			else
			{
				return null;
			}
		}
		return questionDTO;
		}
		finally{
			if(query!=null){
				query.close();
				}
				if(connection!=null){
					connection.close();
				}	
		}
		
	}


	public static ArrayList<AttemptedTestDTO> getAttemptedTests(String userId) throws ClassNotFoundException, SQLException {
		AttemptedTestDTO attempted = new AttemptedTestDTO();
		ArrayList<AttemptedTestDTO> attemptedList = new ArrayList<AttemptedTestDTO>();
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;
		try
		{
			 connection = getConnection();
		 query = connection.prepareStatement("select testId, marksObt, isPass from "+userId+";");
		 result = query.executeQuery();
		if(result.next())
		{
			do
			{
				attempted.setAttemptedTestId(result.getString("testId"));
				attempted.setMarksObtained(result.getInt("marksObt"));
				attempted.setPaas(result.getBoolean("isPass"));
				attemptedList.add(attempted);
			}while(result.next());
			return attemptedList;
		}
		return null;
		}
		finally
		{
			if(null != query)
			{
				query.close();
			}
			if(null != connection)
			{
				connection.close();
			}
		}
	}


	public static ArrayList<TestListDTO> getTestList() throws SQLException, ClassNotFoundException {
		ArrayList<TestListDTO> testList = new ArrayList<TestListDTO>();
		TestListDTO tests = null;
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;
		int counter = 0;
		try
		{
			connection = getConnection();
			query = connection.prepareStatement("select * from testTable;");
			result = query.executeQuery();
			
			if(result.next())
			{
				do
				{
					tests = new TestListDTO();
					tests.setTestId(result.getString("testId").toUpperCase());
					tests.setSubject(result.getString("subject").toUpperCase());
					tests.setMm(result.getInt("mm"));
					tests.setTime(result.getInt("time"));
					tests.setNoOfQue(result.getInt("noOfQue"));
					tests.setLevel(result.getInt("level"));
					tests.setTestUrl("?id="+result.getString("testId").toLowerCase());
					testList.add(counter, tests);
					counter++;
				}while(result.next());
				return testList;
			}
		}
		finally
		{
			if(null != result)
			{
				result.close();
			}
			if(null != query)
			{
				query.close();
			}
			if(null != connection)
			{
				connection.close();
			}
		}
		return null;
	}
	
	
	public static String getUserId(String id) throws ClassNotFoundException, SQLException
	{
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;
		connection = getConnection();
		boolean check = checkEntryByUserId(id);
		if(!check)
		{System.out.println("here");
			return id;
		}
		else
		{System.out.println("here2");
			check = checkEntryByEmailId(id);
			if(!check)
			{
			query = connection.prepareStatement("select userId from login where emailId = ?;");
			query.setString(1, id);
			result = query.executeQuery();
			if(result.next())
			{System.out.println("here4");
				return result.getString("userId");
			}
			}
		}
		return "null";
	}
}