package com.hello.dao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Cart;
import com.model.Goods;

@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
	@Autowired
    public JdbcTemplate jdbcTemplate;

	@Override
	public  List<Goods> getAll() {
	  String sql = "select * from goods";
	  RowMapper<Goods> rowMapper=new BeanPropertyRowMapper<Goods>(Goods.class);
	  List<Goods> goods= jdbcTemplate.query(sql, rowMapper);
	  return goods;
	}

	@Override
	public void addGood(Cart cart) {
		jdbcTemplate.update("insert into cart(u_id,g_id) values(?,?)",
				cart.getU_id(),cart.getG_id());
		
	}

	@Override
	public List<Goods> showList(int uid) {
		 String sql="select g.* from goods g,cart c where c.g_id =g.id and c.u_id=?";
		 RowMapper<Goods> rowMapper=new BeanPropertyRowMapper<Goods>(Goods.class);
		 List<Goods> cartList=jdbcTemplate.query(sql, rowMapper, uid);
	     return cartList;
	}	  
}
