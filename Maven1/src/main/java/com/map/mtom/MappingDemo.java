package com.map.mtom;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1=new Emp();
		Emp e2=new Emp();
		e1.setEid(1);
		e1.setName("Shivi");
		
		e2.setEid(2);
		e2.setName("Shivangi");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(101);
		p1.setProjectName("Library Management System");
		
		p2.setPid(102);
		p2.setProjectName("E-commerce websites");
		
		List<Project> list=new ArrayList<Project>();
		list.add(p1);
		list.add(p2);
		
		List<Emp> list1=new ArrayList<Emp>();
		list1.add(e1);
		list1.add(e2);
		
		e1.setProject(list);
		p1.setEmps(list1);
		
		
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		tx.commit();
		
		//fetching
	
		Emp e=(Emp)session.get(Emp.class, 1);
		System.out.println(e.getName());
		for(Project a:e.getProject()) {
			System.out.println(a.getProjectName());
		}
		Project p=(Project)session.get(Project.class, 101);
		System.out.println(p.getProjectName());
		for(Emp a:p.getEmps()) {
			System.out.println(a.getName());
		}
		
		session.close();
		factory.close();
	}

}
