package com.mapping;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Question question = new Question();
		question.setQuestionId(1);
		question.setQuestion("what is java");

		Answer answer = new Answer();
		answer.setAnswerId(101);
		answer.setAnswer("java is a programming language");
		answer.setQuestion(question);
		
	
		Answer answer1 = new Answer();
		answer1.setAnswerId(102);
		answer1.setAnswer("java is more secure language than others");
		answer1.setQuestion(question);
		

		Answer answer2 = new Answer();
		answer2.setAnswerId(103);
		answer2.setAnswer("java has different type of framework");
		answer2.setQuestion(question);
		
		List<Answer> list =new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		question.setAnswers(list);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 * for one to one session.save(question); session.save(answer);
		 * session.save(question1); session.save(answer1);
		 */
		
		session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);
        
		tx.commit();

//		// fetching data for one to one
//		Question q = (Question) session.get(Question.class, 1);
//		System.out.println(q.getQuestion() + ":" + q.getAnswer().getAnswer());
//
//		Answer a = (Answer) session.get(Answer.class, 101);
//		System.out.println(a.getAnswer() + ":" + a.getQuestion().getQuestion());
		
		
		//fetching data for one to many
//		Question q = (Question) session.get(Question.class, 1);
//		System.out.println(q.getQuestion());
//		for(Answer a1: q.getAnswers()) {
//			System.out.println(a1.getAnswer());
//		}

		session.close();

		factory.close();
	}

}
