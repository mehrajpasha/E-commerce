package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.Dao.CartDAO;
import com.niit.shoppingcart.Dao.CategoryDAO;
import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.Dao.SupplierDAO;
import com.niit.shoppingcart.Dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;
@Controller
public class AdminController {
	
	
	@Autowired
	UserDetailsDAO userdetailsDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value ="/Admin" )
	public ModelAndView SupplierPage() {
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("cartClicked", "true");
		return mv;
}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetails user = userdetailsDAO.get1(username);
		session.setAttribute("userid", user.getId());
		session.setAttribute("name", user.getUsername());
		session.setAttribute("LoggedIn", "true");
		

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 session.setAttribute("cartsize",cartDAO.getsize((int)session.getAttribute("userid")));
		    	 return "redirect:/";
		     }
		     
		     else 
		     {
		    	 session.setAttribute("Admin", "true");
		    	/* model.addAttribute("productList", productDAO.list());
		 		model.addAttribute("categoryList",categoryDAO.list());
		 		model.addAttribute("supplierList",supplierDAO.list());
		 		model.addAttribute("UserClickedproduct", "true");*/
		 		return "/Admin";
			 }
		}
		return "Home";
	}

	@RequestMapping(value="/loginError")
	public String loginerror(RedirectAttributes attributes){
		attributes.addFlashAttribute("error", "Oops! The Username or Password you entered is Incorrect");
		return "redirect:/Login";
	}
}
