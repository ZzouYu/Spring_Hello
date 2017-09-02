package testUser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.model.User;


import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class TestRedis {
	 private Jedis jedis; 
	      private int  userId  =233;
	   @Before
	    public void setup() {
	       //连接redis服务器，192.168.0.100:6379
	     jedis = new Jedis("127.0.0.1", 6379);
      
    }
/*	   @Test
	   public void test01(){
		   jedis.set("mykey", "ab");
		   System.out.println(jedis.get("mykey"));
	   }*/
	   @Test
	   public void test02(){
		   User user=new User();
		   user.setId(userId);
		   user.setUsername("张三");
		   JSONObject usera = JSONObject.fromObject(user);  
		   jedis.set("user"+user.getId(), usera.toString());
		   System.out.println(jedis.get("mykey"));
	   }
	   @Test
	   public void test03(){
		   String userStr=jedis.get("user"+userId);
		   JSONObject jsonObj =JSONObject.fromObject(userStr);
		   User user = (User) JSONObject.toBean(jsonObj,User.class); 
		   System.out.println(user.getUsername());
	   }
	   @Test
	   public  void testMap(){
		   Map<String, String> map = new HashMap<String, String>();
		           map.put("name", "xinxin");
		           map.put("age", "22");
		           map.put("qq", "123456");
		     jedis.hmset("user", map);
		     List<String> hg=jedis.hmget("user", "name","age","qq");
		    System.out.println(hg);
		    jedis.hdel("user", "age");
		    System.out.println(jedis.hmget("user", "age"));
		    System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2 
		    System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
		    System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
		    System.out.println(jedis.hvals("user"));//返回map对象中的所有value 
		    
		    Iterator<String> iter=jedis.hkeys("user").iterator();
		    while(iter.hasNext()){
		    	String key=iter.next();
		    	System.out.println(key+":"+jedis.hmget("user",key));
		    }  
	   }
	   @Test
	   public void testList(){
	    	 jedis.lpush("java framework","spring");  
	    	 jedis.lpush("java framework","struts");  
	    	 jedis.lpush("java framework","hibernate");
	    	 //获取列表指定范围内的元素
	    	 System.out.println(jedis.lrange("java framework",0, -1));	 
	    }
	   @Test
	   public void testSet(){
		   jedis.del("user");  
		   System.out.println(jedis.lrange("user",0,-1));  
		   jedis.sadd("user","liuling");  
		   jedis.sadd("user","xinxin");  
		   jedis.sadd("user","ling");  
		   jedis.sadd("user","zhangxinxin");
		   jedis.sadd("user","who"); 
		   //移除
		   jedis.srem("user","who"); 
		   System.out.println(jedis.smembers("user"));//获取所有加入的value  
		   System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素  
		   System.out.println(jedis.srandmember("user"));  //返回集合一个或多个随机数
		   System.out.println(jedis.scard("user"));//返回集合的元素个数  
		}
	  @Test
	  public void testSort() throws InterruptedException{
		  jedis.del("a");//先清除数据，再加入数据进行测试  
		  jedis.rpush("a","1");  
		  jedis.lpush("a","6");  
		  jedis.lpush("a","3");  
		  jedis.lpush("a","9");  
		  System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]  
		  System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果  
		  System.out.println(jedis.lrange("a",0,-1)); 
	  }
	  
}

