package com.hello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Catagery;
import com.model.CatageryGroup;
@Repository("catageryGroupDaoImpl")
public class CatageryGroupDaoImpl implements CatageryGroupDao{
	@Autowired
    public JdbcTemplate jdbcTemplate;
	@Override
	public List<CatageryGroup> getAll() {
		
		 String sql="select * from catageryGroup";
		 RowMapper<CatageryGroup> rowMapper=new BeanPropertyRowMapper<CatageryGroup>(CatageryGroup.class);
		 List<CatageryGroup> catageryGroupList=this.jdbcTemplate.query(sql, rowMapper);
	     return catageryGroupList;
	}
    
	
}
