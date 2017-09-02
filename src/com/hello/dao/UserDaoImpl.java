package com.hello.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hello.exception.MeiRenException;
import com.model.Employee;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao  {
	  @Autowired
	    public JdbcTemplate jdbcTemplate;
	    
	    public Employee get(Integer id){
	        String sql="select id,lastName,email from employee where id=?";
	        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
	        Employee employee=jdbcTemplate.queryForObject(sql, rowMapper, id);
	        return employee;
	    }
		@Override
		public Employee findUsername(String username,String password) {
			try {
				String sql = "select * from employee where username=? and password=?";
		      
			   RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
			  Employee employee= jdbcTemplate.queryForObject(sql, rowMapper, username,password);
			  return employee;
			} catch (Exception e) {
				return null;
			}
	}
		

		
		@Override
		public void save(Employee employee){
			String sql="insert into employee(lastName,email,username,password) values(?,?,?,?)";
			jdbcTemplate.update(sql, employee.getLastName(),employee.getEmail(),
					employee.getUsername(),employee.getPassword());
		
		}
}
