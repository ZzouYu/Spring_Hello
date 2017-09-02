package com.hello.service;

import java.util.List;

import com.model.Catagery;

public interface CatageryService {

	 List<Catagery> getAll() ;

	 List<Catagery> findCatageryByGroupId(int groupId);
	
}
