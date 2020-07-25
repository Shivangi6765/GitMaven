package com.pagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;

import com.learn.Maven1.Student;

public class Pagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.openSession();
		Query<Student> q=session.createQuery("from Student");
		//pagination
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Student> list=q.list();
		for(Student s:list) {
			System.out.println(s.getCity());
		}
		session.close();
		factory.close();

	}

}
