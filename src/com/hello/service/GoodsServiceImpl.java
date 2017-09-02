package com.hello.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.GoodsDao;
import com.model.Cart;
import com.model.Goods;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	  @Resource(name="goodsDao")
      private GoodsDao  goodsDao;
      @Resource(name="goodsDao")
		public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
      
      private Cart cart;
		@Override
		public List<Goods>  getAll() {
			return goodsDao.getAll();
		}
	

		@Override
		public void addGood(Integer id, int id2) {
			Cart cart=new Cart(id,id2);
			goodsDao.addGood(cart);	
		}


		@Override
		public List<Goods>  showList(int uid) {
			return goodsDao.showList(uid);
		}


			   	
}
