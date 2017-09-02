package com.hello.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hello.service.CatageryGroupService;
import com.hello.service.CatageryService;
import com.hello.service.ProductService;
import com.model.Catagery;
import com.model.CatageryGroup;
import com.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController{
	
	@Resource(name="productServiceImpl")
	private ProductService productService;
	
    @Resource(name="productServiceImpl")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
    @Resource(name="catageryServiceImpl")
	private CatageryService catageryService;
	
    @Resource(name="catageryServiceImpl")
	public void setCatageryService(CatageryService catageryService) {
		this.catageryService = catageryService;
	}
    @Resource(name="catageryGroupServiceImpl")
	private CatageryGroupService catageryGroupService;
	 
    @Resource(name="catageryGroupServiceImpl")
	public void setCatageryGroupService(CatageryGroupService catageryGroupService) {
		this.catageryGroupService = catageryGroupService;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String showAllProducts(Model model){
		List<CatageryGroup> list=catageryGroupService.getAll();
		if(null != list){
			for (CatageryGroup catageryGroup:list) {
				List<Catagery> catageryList = catageryService.findCatageryByGroupId(catageryGroup.getId());
				catageryGroup.setCatageryList(catageryList);
			}
		}
		model.addAttribute("list_group",list);
		model.addAttribute("list", productService.findAll());
		return "product/list";		
	}	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct(Model model){
		List<CatageryGroup> list=catageryGroupService.getAll();
		if(null != list){
			for (CatageryGroup catageryGroup:list) {
				List<Catagery> catageryList = catageryService.findCatageryByGroupId(catageryGroup.getId());
				catageryGroup.setCatageryList(catageryList);
			}
		}
		model.addAttribute("list_group",list);
		//model.addAttribute("list_catagery",catageryService.getAll());
		return "product/addProduct";	
	}	
	@RequestMapping(value="/product_add",method=RequestMethod.POST)
		public String saveProduct(Product product,String groupIds,@RequestParam("attachs")MultipartFile[] attachs,HttpServletRequest req) throws IOException{
		  String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
		  System.out.println(realpath);
		   for(MultipartFile attach:attachs){
			   if(attach.isEmpty()) continue;
			   File f = new File(realpath+"/"+attach.getOriginalFilename());
			   FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
		   }
		   int productId= productService.saveProduct(product);
		    productService. saveProductId( productId,groupIds);
		    return "redirect:/product/list";	 	
	}
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable Integer id){
	  productService.deleteProduct(id);
	  productService.deleteProductcatagery(id);
	    return "redirect:/product/list";	 	
}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String searchProduct(Model model,String groupIds){
		List<CatageryGroup> list=catageryGroupService.getAll();
		if(null != list){
			for(CatageryGroup catageryGroup:list) {
				List<Catagery> catageryList = catageryService.findCatageryByGroupId(catageryGroup.getId());
				catageryGroup.setCatageryList(catageryList);
			}
		}
		model.addAttribute("list_group",list);
		model.addAttribute("list",productService.searchProduct(groupIds));
		model.addAttribute("groupIds", groupIds);
	    return "product/list";	 	
}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showProducts(Model model){
		List<CatageryGroup> list=catageryGroupService.getAll();
		if(null != list){
			for (CatageryGroup catageryGroup:list) {
				List<Catagery> catageryList = catageryService.findCatageryByGroupId(catageryGroup.getId());
				catageryGroup.setCatageryList(catageryList);
			}
		}
		model.addAttribute("list_group",list);
		model.addAttribute("list", productService.findAll());
		return "product/show";		
	}	
}
