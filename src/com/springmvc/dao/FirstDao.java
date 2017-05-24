package com.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bean.User;

//@Transactional
@Repository
public class FirstDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		User user = new User();
//		user.setUsername("aaa");
//		user.setPassword("123");
		session.save(user);
		tx.commit();
		session.close();
	}
}
