package testUser;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.hello.dao.UserDao;
import com.hello.service.UserService;
import com.model.Employee;

public class TestUser {
   
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate;
    private UserService userService;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    {
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
        userService=ctx.getBean(UserService.class);
        namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
    }
    @Test
     public void testNamedParameterJdbcTemplate2(){
    	String sql="insert into employee(lastName,email) values(:lastName,:email)";
        Employee employee=new Employee();
        employee.setLastName("panpan");
        employee.setEmail("@panpan");
        SqlParameterSource paramSource=new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, paramSource);
   }
    
    @Test
    public void testUserGet(){
    	userService.get(1);
    	
    }
}
