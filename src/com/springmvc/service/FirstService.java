package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.bean.User;
import com.springmvc.dao.FirstDao;

@Service
public class FirstService {

	@Autowired
	private FirstDao firstDao;
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		if(userName !="" && password !=""){
			firstDao.save(user);
		}
		return user;
	}

	
}
