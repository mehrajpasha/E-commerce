package com.niit.shoppingcartserver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.Dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDetailsDAO userdetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		UserDetails userdetails = (UserDetails) context.getBean("userdetails");

		userdetails.setId(8);
		userdetails.setUsername("mehraj");
		userdetails.setPassword("munna786");
		userdetails.setMail("mehrajrockon@gmail.com");
		userdetails.setContact("8985363545");
		userdetails.setAddress("hyderabad");

		if (userdetailsDAO.saveOrUpdate(userdetails) == true) {
			System.out.println("userDetails created successfully");
		} else {
			System.out.println("not able to create userDetails");
		}

	}
}

