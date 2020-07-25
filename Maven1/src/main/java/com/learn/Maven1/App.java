package com.learn.Maven1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!");
		Configuration cfg = new Configuration();
		// at that time the xml file is in right track..so we don't need to give
		// file....if we have to given then give..
		// if it is in package then give full package name with file name as
		// com/learn/Maven1/hibernate.cfg.xml...
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student = new Student();
		student.setId(2);
		student.setName("Shivangi");
		student.setCity("Saharanpur");
		System.out.println(student);

		Address ad = new Address();
		// id set ni hogi because it is auto_increment
		ad.setStreet("Street1");
		ad.setCity("Saharanpur");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(2.45666);
		
		//Reading image
		
		FileInputStream fis=new FileInputStream("src/main/java/mountain.jpg");
		
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done");
		factory.close();

	}
}
