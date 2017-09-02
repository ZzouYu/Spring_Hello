package com.hello.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hello.service.UserService;
import com.hello.util.CookieUtil;
import com.model.Employee;

@Controller
@RequestMapping("/employ")
@SessionAttributes("loginUser")
 public class LoginController{
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public String login(String username, String password,Model model,HttpServletResponse response) {
		Employee em = userService.login(username,password);
		if(em!=null){
			 model.addAttribute("loginUser", em);
			 CookieUtil.addCookie(response, "userId", em.getId()+"", 60*60*24*7);
			return "redirect:/buy";
		}else{
		  return "login";
		}		
}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String save(Model model){
		model.addAttribute(new Employee());
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String save(Employee employee){
		userService.save(employee);
		return "success1";
	}
}


