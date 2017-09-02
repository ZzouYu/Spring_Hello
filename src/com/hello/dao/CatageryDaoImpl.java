package com.hello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Catagery;

@Repository("catageryDaoImpl")
public class CatageryDaoImpl implements CatageryDao{
	@Autowired
    public JdbcTemplate jdbcTemplate;
	@Override
	public List<Catagery> getAll() {
	
		String sql="select * from catagery";
		 RowMapper<Catagery> rowMapper=new BeanPropertyRowMapper<Catagery>(Catagery.class);
		 List<Catagery> catageryList=this.jdbcTemplate.query(sql, rowMapper);
	     return catageryList;
	}
	
	public List<Catagery> findCatageryByGroupId(int groupId){
		String sql="select * from catagery where groupId = ?";
		 RowMapper<Catagery> rowMapper=new BeanPropertyRowMapper<Catagery>(Catagery.class);
		 List<Catagery> catageryList=this.jdbcTemplate.query(sql, rowMapper,groupId);
	     return catageryList;
	}
}
