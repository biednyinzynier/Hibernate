package com.burak.employee.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.burak.employee.entity.Employee;

public class SelectEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Employee.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			// select
			List<Employee> employees = session.createQuery("from Employee where company='Oracle'").getResultList();
			
			//
			for (Employee tempEmployee : employees) {
				System.out.println(tempEmployee);
			}
			
			// commit
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			
		} finally {
			factory.close();
		}
		
	}
}
