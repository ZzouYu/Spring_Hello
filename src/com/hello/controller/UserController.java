package com.hello.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.model.User;
import com.model.UserException;


@Controller
@RequestMapping("/user")
public class UserController {
   private Map<String,User> users=new HashMap<String,User>();
   
   public UserController(){
	   users.put("gy",new User("gy","123","关羽","sd"));
	   users.put("zf",new User("zf","123","张飞","sd"));
	   users.put("lb",new User("lb","123","刘备","sd"));
	   users.put("zy",new User("zy","123","赵云","sd"));
   }
   @RequestMapping(value="/users",method=RequestMethod.GET)
   public String list(Model model){
	  model.addAttribute("users",users);
	  return "user/list";
   }
   @RequestMapping(value="/add",method=RequestMethod.GET)
   public String add(Model model){
	   model.addAttribute(new User());
	   return "user/add";
   }
   @RequestMapping(value="/add",method=RequestMethod.POST)
   public String add(@Validated User user,BindingResult br,@RequestParam("attachs")MultipartFile[] attachs,HttpServletRequest req) throws IOException{
	   if(br.hasErrors()){
		   return "user/add";
	   }
	   String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
	   System.out.println(realpath);
	   for(MultipartFile attach:attachs){
		   if(attach.isEmpty()) continue;
		   File f = new File(realpath+"/"+attach.getOriginalFilename());
		   FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
	   }
	   users.put(user.getUsername(), user);
	   return "redirect:/user/users";
   }
   @RequestMapping(value="/{username}",method=RequestMethod.GET)
   public String show(@PathVariable String username,Model model){
	   model.addAttribute(users.get(username));
	   return "user/show";
   } 
   @RequestMapping(value="/{username}",method=RequestMethod.GET,params="json")
   @ResponseBody
   public User show(@PathVariable String username){
	   return users.get(username);
   } 
   @RequestMapping(value="/{username}/update",method=RequestMethod.GET)
   public String update(@PathVariable String username,Model model){
	   User user = users.get(username);
	   if(null == user){
		   user = new User("zwwy","123","赵云","sd");
	   }
	   model.addAttribute(user);
	   return "user/update";
   }
   @RequestMapping(value="/{username}/update",method=RequestMethod.POST)
   public String update(@PathVariable String username,@Validated User user,BindingResult br){
	   if(br.hasErrors()){
		   return "user/update";
	   }
	   users.put(username,user);
	   return "redirect:/user/users";
   }
   @RequestMapping(value="/{username}/delete",method=RequestMethod.GET)
   public String delete(@PathVariable String username){
	   users.remove(username);
	   return "redirect:/user/users";
   }
//   @RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(String username,String password,HttpSession session) {
//		if(!users.containsKey(username)) {
//			throw new UserException("用户名不存在");
//		}
//		User u = users.get(username);
//		if(!u.getPassword().equals(password)) {
//			throw new UserException("用户密码不正确");
//		}
//		session.setAttribute("loginUser", u);
//		return "redirect:/user/users";
//	}
}

