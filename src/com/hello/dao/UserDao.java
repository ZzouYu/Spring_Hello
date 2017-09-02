package com.hello.dao;


import com.hello.exception.MeiRenException;
import com.model.Employee;

public interface UserDao {
    public Employee get(Integer id);
	public Employee findUsername(String username,String password);
	public void save(Employee employee);
	
	
}
