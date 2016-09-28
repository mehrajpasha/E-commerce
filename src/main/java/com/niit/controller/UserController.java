package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.Dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	UserDetailsDAO userdetailsDAO;
	@Autowired
	UserDetails userdetails;
	@RequestMapping(value="adduser")
	public String adduserdetails(@ModelAttribute("userdetails") UserDetails  userdetails, Model m,RedirectAttributes attributes)
	{
        userdetails.setRole("ROLE_USER");
        userdetails.setEnabled(true);
        if(userdetailsDAO.saveOrUpdate(userdetails)==true){
        	attributes.addFlashAttribute("register", "YOu Have Successfully Registered with us Thank You...");
        }
        else{
        	attributes.addFlashAttribute("register","Registration failed Please try again");
        }
		return "redirect:/Register";
	}
	@RequestMapping(value="Register")
	public ModelAndView user(@ModelAttribute("userdetails") UserDetails userdetails){
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("UserClickeduser","true");
		mv.addObject("HideOthers", "true");
		return mv;
	}
}
