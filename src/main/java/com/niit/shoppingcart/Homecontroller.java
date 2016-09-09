package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.Dao.CategoryDAO;

@Controller
public class Homecontroller {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/")
	public String homepage(Model m){
		m.addAttribute("categoryList", categoryDAO.list());
	return "Home" ;	
	}


@RequestMapping("/Login")
public ModelAndView login()
{
	ModelAndView mv = new ModelAndView("Login");
	return mv;
}
@RequestMapping("/Register")
public ModelAndView register()
{
	ModelAndView mv= new ModelAndView("Register");
	return mv;
	
}
/*@RequestMapping("/singlecategory/{id}")
public ModelAndView productcontroller(@PathVariable("id") int id)	
{
	ModelAndView mv=new ModelAndView("CategoryItems");
	mv.addObject("msg", "attributeValue");
	return mv;
}*/
}