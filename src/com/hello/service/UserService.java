package com.hello.service;

import com.model.Employee;

public interface UserService {
    public Employee get(Integer id);
    public Employee login(String username,String password);
	public void save(Employee employee);
	
}
