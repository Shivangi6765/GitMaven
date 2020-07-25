package com.learn.Maven1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetchdemo {
     public static void main(String[] args) {
		
	
	Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session=factory.openSession();
	Student st=(Student)session.get(Student.class, 2);
	System.out.println(st);
	Address ad=(Address)session.load(Address.class, 2);
	System.out.println(ad.getCity());
	
	session.close();
	factory.close();
     }
}
