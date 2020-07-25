package com.learn.Maven1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatesDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student student=new Student();
		student.setId(101);
		student.setName("Amit");
		student.setCity("Merrut");
		student.setCerti(new Certificate("hibernate","2 months"));
		//soo aab ye tranisient state mai hai....
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(student);
		//aab ye persistent state m hai....
		student.setName("Prince");
		tx.commit();
		session.close();
		//Detached state
		//aab esme aagr koi change krenge too aab db mai change nhi hoga....but console pr print krenge too change hoyegii bss..
		factory.close();

	}

}
