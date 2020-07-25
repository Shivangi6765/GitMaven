package com.hql;

import java.util.*;
import org.hibernate.query.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learn.Maven1.Student;

public class HqlExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//HQL
		
		//String query="from Student where city='S.R.E";
		//for dynamic content
		//String query="from Student where city=:x";
		//used as alias
		String query1="from Student as s where s.city=:x and s.name=:y";
		
		//cross isiliye aara hai kuki ye method depricated ho gya hai ....to solve this import org.hibernate.query.*;
		//Query q=session.createQuery(query);
		Query q1=session.createQuery(query1);
		
		//q.setParameter("x", "S.R.E");
		q1.setParameter("x", "S.R.E");
		q1.setParameter("y", "Shivi");
		//single
		//Student st=(Student)q.uniqueResult();
		//for single result ke liye
		//multile results
		List<Student> list=q1.list();
		for(Student s:list) {
			System.out.println(s.getName());
		}
	
		System.out.println("____________________________________________________________");
		Transaction tx=session.beginTransaction();
		
		//delete query
//		Query q=session.createQuery("delete from Student where city=:a");
//		//delete from Student where city='Saharanpur'
//		q.setParameter("a", "Saharanpur");
//		int r=q.executeUpdate();
//		System.out.println(r);
		Query q=session.createQuery("update Student set city=:a where id=:d");
		q.setParameter("a", "Merrut");
		q.setParameter("d", 1);
		int r=q.executeUpdate();
		System.out.println(r);
		//for join
		Query q3=session.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		List<Object[]> list1=q3.getResultList();
		for(Object[] arr:list1) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
