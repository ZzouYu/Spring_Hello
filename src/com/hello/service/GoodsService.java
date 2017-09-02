package com.hello.service;



import java.util.List;

import com.model.Cart;
import com.model.Goods;



public interface GoodsService {
	public List<Goods> getAll();

	public void addGood(Integer id, int id2);


	

	public List<Goods>  showList(int uid);

}
