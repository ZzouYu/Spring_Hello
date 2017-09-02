package com.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	@Autowired
    public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> findAll() {
		 String sql="select * from product";
		 RowMapper<Product> rowMapper=new BeanPropertyRowMapper<Product>(Product.class);
		 List<Product> productList=this.jdbcTemplate.query(sql, rowMapper);
	     return productList;
	}

	@Override
	public int saveProduct( final Product product) {
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		  jdbcTemplate.update(new PreparedStatementCreator() {  
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {  
		        	   String sql="insert into  product (`name`,`desc`,image,price) values('"+product.getName()+"','"+product.getDesc()+"','"+
		        product.getImage()+"',"+product.getPrice()+")";  
		        	   System.out.println(sql);
		               PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);     
		               return ps;  
		        }  
		    }, keyHolder);  
		  return  keyHolder.getKey().intValue();  
}
	
	@Override
	public void saveProductId(int productId, String groupIds) {
		jdbcTemplate.update("insert into product_catagerId(productId,catageryId) values(?,?)",
				productId,Integer.parseInt(String.valueOf(groupIds.charAt(0))));
		jdbcTemplate.update("insert into product_catagerId(productId,catageryId) values(?,?)",
				productId,Integer.parseInt(String.valueOf(groupIds.charAt(2))));
	}

	@Override
	public void deleteProduct(Integer id) {
		 String sql = "delete  from product where id="+id;  
		 jdbcTemplate.update(sql);	
	}

	@Override
	public void deleteProductcatagery(Integer id) {
		 String sql = "delete  from product_catagerid where productId="+id;  
		 jdbcTemplate.update(sql);	
	}
	@Override
	public List<Product> searchProduct(String groupIds) {
		String sql ="select p.*FROM product p,(select a.productId from (select productId from product_catagerid where catageryId="+Integer.parseInt(String.valueOf(groupIds.charAt(0)))+") a join (select productId  from product_catagerid  where catageryId="+Integer.parseInt(String.valueOf(groupIds.charAt(2)))+") b on a.productId=b.productId)c WHERE p.id=c.productId";

		 RowMapper<Product> rowMapper=new BeanPropertyRowMapper<Product>(Product.class);
		 List<Product> searchList=this.jdbcTemplate.query(sql, rowMapper);
	     return searchList;
	}
}