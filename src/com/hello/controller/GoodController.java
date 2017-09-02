package com.hello.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hello.service.GoodsService;
import com.hello.util.CookieUtil;

import com.model.Employee;
import com.model.Goods;

@Controller
@SessionAttributes("list")
public class GoodController{
	private Goods goods;
	private Employee employee;
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
    @Resource(name="goodsService")
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	@RequestMapping(value="/buy",method=RequestMethod.GET)
	public String showAllGoods(Model model){
		model.addAttribute("list", goodsService.getAll());
		return "showGoods";		
	}
	@RequestMapping(value="/mycart",method=RequestMethod.GET)
	@ResponseBody
    public String addGoodToCart(int goodsId,HttpServletRequest request){
		 goodsService.addGood(Integer.parseInt(CookieUtil.getUid(request, "userId")),goodsId);
		 return "1";
	}
	@RequestMapping(value="/listCart",method=RequestMethod.GET)
	
    public String showCart(Model model,HttpServletRequest request){
		 model.addAttribute("listCart",goodsService.showList(Integer.parseInt(CookieUtil.getUid(request, "userId"))));
		 return "listCart";
	}
	
}
