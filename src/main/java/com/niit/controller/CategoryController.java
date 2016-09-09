package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.Dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	
	 private Path path;

	@RequestMapping(value={"editcategory","addeditcategory/{id}/editcategory"})
	public String editcategory(@ModelAttribute("category") Category category, HttpServletRequest request,Model m){
		categoryDAO.saveOrUpdate(category);
		return "redirect:/Category";
	}
	
    @RequestMapping(value ="Category")
	public ModelAndView CategoryPage(@ModelAttribute("category") Category category,BindingResult result) 
	{	ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("UserClickedcategory", "true");
		return mv;
	}
@RequestMapping(value ="addeditcategory/{id}" )
public String CategoryPageedit(@PathVariable("id") int id,RedirectAttributes attributes,HttpServletRequest request) 
{
	attributes.addFlashAttribute("category", this.categoryDAO.get(id));
    	return "redirect:/Category";
    
}
@RequestMapping(value ={"adddeletecategory/{id}"} )
public String CategoryPagedelete(@PathVariable("id") int id, @ModelAttribute("category") Category category,Model m,HttpServletRequest request) {
	categoryDAO.delete(category);
	return "redirect:/Category";
}
}
