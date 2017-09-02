package com.hello.dao;

import java.util.List;

import com.model.Catagery;

public interface CatageryDao {

	List<Catagery> getAll();
    
	List<Catagery> findCatageryByGroupId(int groupId);
}
