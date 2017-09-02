package com.hello.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.dao.UserDao;
import com.hello.exception.MeiRenException;
import com.model.Employee;

@Service("userService")
public class UserServiceImpl implements UserService {
   
   @Resource(name="userDao") 
   private UserDao userDao;
   @Resource(name="userDao") 
	public void setUserdao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("heiren");
		return userDao.get(id);
	}
	@Override
	public Employee login(String username,String password) {
		Employee em = userDao.findUsername(username,password);
		return em;
	}
	@Override
	public void save(Employee employee){
		 
			userDao.save(employee);
	}
}
