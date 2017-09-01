package com.hibernate.examples;



public class TestHibernate {

	public static void main(String[] args) {
		Employee ram = new Employee();
		ram.setId(1001);
		ram.setName("Ram");
		ram.setSalary(90000);
		EmployeeDAO empDAO = new EmployeeDAO();
		String message = empDAO.addNewEmployee(ram);
		System.out.println("Message is "+message);
		
		
		message = empDAO.updateExistingEmployee(1001);
		System.out.println("Message is "+message);
		
	}

}