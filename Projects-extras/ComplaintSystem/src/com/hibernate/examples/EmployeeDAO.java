package com.hibernate.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public String addNewEmployee(Employee empObject){
		String result ="Error in Record Addition";

		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(empObject);
		trans.commit();
		System.out.println("Record Added...");
		session.close();
		
		return result;
	}
	
	public String deleteExistingEmployee(int empId){
		String result ="Error in Record Deletion";

		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Employee empObject = (Employee)session.get(Employee.class, empId);
		if(empObject==null){
			result = "Emp Record not found so can't delete";
		}
		else
		{
			session.delete(empObject);
			result = "Delete SuccessFully...";
		}
		
		trans.commit();
		
		session.close();
		
		return result;
	}
	
	public String updateExistingEmployee(int empId){
		String result ="Error in Record Updation";

		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Employee empObject = (Employee)session.get(Employee.class, empId);
		if(empObject==null){
			result = "Emp Record not found so can't Update";
		}
		else
		{
			empObject.setSalary(empObject.getSalary()+9000);
			session.update(empObject);
			result = "Update SuccessFully...";
		}
		
		trans.commit();
		
		session.close();
		
		return result;
	}
	

}