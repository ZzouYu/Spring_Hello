package com.hello.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.dao.CatageryDao;
import com.hello.dao.ProductDao;
import com.model.Catagery;

@Service("catageryServiceImpl")
public class CatageryServiceImpl implements CatageryService{
	@Resource(name="catageryDaoImpl")
	private CatageryDao catageryDao;
	@Resource(name="catageryDaoImpl")
	
	public void setCatageryDao(CatageryDao catageryDao) {
		this.catageryDao = catageryDao;
	}

	@Override
	public List<Catagery> getAll() {
		return catageryDao.getAll();
	}

	@Override
	public List<Catagery> findCatageryByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return catageryDao.findCatageryByGroupId(groupId);
	}

	
}
