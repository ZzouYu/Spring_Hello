package com.hello.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.dao.CatageryDao;
import com.hello.dao.CatageryGroupDao;
import com.model.CatageryGroup;
@Service("catageryGroupServiceImpl")
public class CatageryGroupServiceImpl implements CatageryGroupService{
	@Resource(name="catageryGroupDaoImpl")
	private CatageryGroupDao catageryGroupDao;
	@Resource(name="catageryGroupDaoImpl")
	public void setCatageryGroupDao(CatageryGroupDao catageryGroupDao) {
		this.catageryGroupDao = catageryGroupDao;
	}
	@Override
	public List<CatageryGroup> getAll() {
		
		return catageryGroupDao.getAll();
	}
	
    
	
}
