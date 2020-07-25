package com.learn.Maven1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student s=new Student();
		s.setId(1);
		s.setName("Shivi");
		s.setCity("S.R.E");
	    
		Certificate certificate=new Certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("2 months");
		
		s.setCerti(certificate);
		
		
		
        Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
		
		
		
		
		factory.close();

	}

}
