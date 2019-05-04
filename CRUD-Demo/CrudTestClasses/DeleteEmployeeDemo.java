package com.burak.employee.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.burak.employee.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Employee.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			// delete
			session.createQuery("delete from Employee where id='1'").executeUpdate();
			
			// commit
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			
		} finally {
			factory.close();
		}
		
	}
}
