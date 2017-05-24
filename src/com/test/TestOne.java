package com.test;


import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springmvc.bean.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration("/applicationContext.xml")
public class TestOne {
	private ApplicationContext context = null;
	@Test
	public void test(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource);
		
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("123");
		session.save(user);
		tx.commit();
		session.close();
 		
	}
}
