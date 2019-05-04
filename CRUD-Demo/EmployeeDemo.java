package com.burak.employee.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.burak.employee.entity.Employee;

public class EmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
			// start transaction
			session.beginTransaction();
			
			// retrieve the data based on id
			int tempId = 1;
			Employee employee = session.get(Employee.class, tempId);
			
			// print
			System.out.println(employee);
			
			// commit transaction	
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	}
}
