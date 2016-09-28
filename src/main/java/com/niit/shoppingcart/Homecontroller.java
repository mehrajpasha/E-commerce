package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.Dao.CategoryDAO;
import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class Homecontroller {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/")
	public String homepage(Model m){
		m.addAttribute("categoryList", categoryDAO.list());
		m.addAttribute("productList", productDAO.list());
		m.addAttribute("Productlist",productDAO.Homelist());
	return "Home" ;	
	}

@RequestMapping("/Login")
public ModelAndView login()
{
	ModelAndView mv = new ModelAndView("Home");
	mv.addObject("UserclickedLogin","true");
	mv.addObject("HideOthers", "true");
	return mv;
}

@RequestMapping("/singlecategory/{id}")
public ModelAndView productcontroller(@PathVariable("id") int id)	
{
	ModelAndView mv=new ModelAndView("Home");
	mv.addObject("productlist", productDAO.getbycategory(id));
	return mv;
}
@RequestMapping("/Individualproduct/{id}")
public String IndividualItem(@PathVariable("id") int id, Model attributes)
{
  
	//attributes.addAttribute("IndividualItemClicked", "true");
	attributes.addAttribute("IndividualProduct", productDAO.getindividual(id));
	return "/Individualproduct";
}
@RequestMapping("/view/{categoryid}")
public String view(@PathVariable("categoryid") int categoryid,Model attributes)
{
	attributes.addAttribute("productlist",productDAO.getbycategory(categoryid));
	attributes.addAttribute("ViewCategoryClicked", "true");
	/*mv.addAttribute("productList",productDAO.getcatitem(categoryid));
	mv.addAttribute("ViewCategoryClicked", "true");*/
	return "/viewproduct";
}

}