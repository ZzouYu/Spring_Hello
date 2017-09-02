package com.hello.dao;

import java.util.List;
import java.util.Map;

import com.model.Cart;
import com.model.Goods;

public interface GoodsDao {

    public List<Goods> getAll();


	public void addGood(Cart cart);


	public List<Goods>  showList(int uid);
}
