package com.burak.employee.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.burak.employee.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Employee.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create new employe object
			Employee employee = new Employee("Burak", "Selvi", "Oracle", "Java Developer", 15000);
			
			// start transaction
			session.beginTransaction();
			
			// save the object to the database
			session.save(employee);
			
			// commit
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			
		} finally {
			factory.close();
		}
		
	}
}
