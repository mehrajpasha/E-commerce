package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.Dao.CartDAO;
import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

@Controller
public class CartController{
	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	
	int q,r;
	@RequestMapping(value ="/Cart" )
	public ModelAndView CartPage(HttpSession session) {
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("cartlist", cartDAO.list());
		mv.addObject("CartPrice", cartDAO.CartPrice((int) session.getAttribute("userid")));
		mv.addObject("cartClicked", "true");
		return mv;
}
	


		@RequestMapping("addtocart/{id}/{userid}")
		public String addToCart(@PathVariable("id") int Productid, @PathVariable("userid") int userid,
				 HttpSession session,RedirectAttributes attributes, Model model) throws Exception {
			
			if (cartDAO.get(Productid, userid) != null) {
				Cart item = cartDAO.get(Productid, userid);
				q=item.getQuantity();
				q=q+1;
				q=item.setQuantity(q);
				Product p = productDAO.get(item.getProductid());
				item.setPrice(q * p.getPrice());
				
				cartDAO.saveOrUpdate(item);
				session.setAttribute("cartsize", cartDAO.getsize((int) session.getAttribute("userid")));
				return "redirect:/Cart";
			} else {
				Cart item = new Cart();
				Product product = productDAO.get(Productid);
				item.setProductname(product.getName());
				item.setUserid(userid);
				r=item.setQuantity(1);
				item.setPrice(r * product.getPrice());
				item.setStatus("C");
				item.setProductid(Productid);
				cartDAO.saveOrUpdate(item);
				session.setAttribute("cartsize", cartDAO.getsize((int) session.getAttribute("userid")));
				
				attributes.addFlashAttribute("cartlist",cartDAO.list());
				return "redirect:/Cart";
			}
		}
		/*System.out.println("welcome");
		if(cartDAO.get(Prodid,userid)!=null )
		{   
			
			Cart c=CartDAO.get(Prodid,userid);
			int t=c.getQuantity();
			t=t+1;
			c.setQuantity(t);
			cartDAO.saveOrUpdate(c);
		}
		else
		{
		Product p=new Product();
		p=productDAO.getindividual(Prodid);
		Cart c=new Cart();
		c.setProductname(p.getName());
		c.setPrice(p.getPrice());
		c.setProductid(p.getId());
		c.setQuantity(1);
		cartDAO.saveOrUpdate(c);*/
	
	
	
	
	@RequestMapping(value="deletecart/{cartid}")
	public String delproduct(@ModelAttribute("cart") Cart cart,Model m)
	{
		cartDAO.delete(cart);
		return "redirect:/Cart";
	}
	
	@RequestMapping("editorder/{cartid}")
	public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {
		Cart cart = cartDAO.get(cartid);
		Product p = productDAO.get(cart.getProductid());
		cart.setQuantity(q);
		cart.setPrice(q * p.getPrice());
		cartDAO.saveOrUpdate(cart);
		session.setAttribute("cartsize", cartDAO.getsize((int) session.getAttribute("userid")));
		return "redirect:/viewcart";
	}
}
